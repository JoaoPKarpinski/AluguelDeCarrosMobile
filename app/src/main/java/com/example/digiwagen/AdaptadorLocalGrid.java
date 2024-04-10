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

public class AdaptadorLocalGrid extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<LocalGridItem> items;

    public AdaptadorLocalGrid(Context context, List<LocalGridItem> items) {
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

    class AdapterItemAux {
        TextView localNome;
        TextView localDescricao;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdapterItemAux itemAux;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_local_grid, null);
            itemAux = new AdapterItemAux();
            itemAux.localNome = ((TextView) convertView.findViewById(R.id.localNomeTextView));
            itemAux.localDescricao = ((TextView) convertView.findViewById(R.id.localDescricaoTextView));
            convertView.setTag(itemAux);
        } else {
            itemAux = (AdapterItemAux) convertView.getTag();
        }
        LocalGridItem item = (LocalGridItem) getItem(position);

        itemAux.localNome.setText(item.getNomeLocal());
        itemAux.localDescricao.setText(item.getDescricaoLocal());

        return convertView;
    }
}
