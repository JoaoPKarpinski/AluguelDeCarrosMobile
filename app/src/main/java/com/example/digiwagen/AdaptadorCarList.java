package com.example.digiwagen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class AdaptadorCarList extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<CarListItem> items;

    public  AdaptadorCarList(Context context, List<CarListItem> items){
        this.items = items;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class AdapterItemAux{
        ImageView carImage;
        TextView carName;
        TextView carRentPrice;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdapterItemAux itemAux;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.item_cars_list, null);
            itemAux = new AdapterItemAux();
            itemAux.carImage = ((ImageView) convertView.findViewById(R.id.carHeroImage));
            itemAux.carName = ((TextView) convertView.findViewById(R.id.carNameTextView));
            itemAux.carRentPrice = ((TextView) convertView.findViewById(R.id.carPriceTextView));
            convertView.setTag(itemAux);
        }else{
            itemAux = (AdapterItemAux) convertView.getTag();
        }
        CarListItem item = (CarListItem) getItem(position);

        itemAux.carImage.setImageResource(item.getImage());
        itemAux.carName.setText(item.getName());
        itemAux.carRentPrice.setText(
                String.format(Locale.getDefault(),"%s%.2f", convertView.getResources().getString(R.string.price_tag), item.getRentPrice())
        );

        return convertView;
    }
}
