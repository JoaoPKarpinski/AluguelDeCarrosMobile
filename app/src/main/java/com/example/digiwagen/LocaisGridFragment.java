package com.example.digiwagen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocaisGridFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocaisGridFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LocaisGridFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FotoGridFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LocaisGridFragment newInstance(String param1, String param2) {
        LocaisGridFragment fragment = new LocaisGridFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_locais_grid, container, false);

        List<LocalGridItem> items = new ArrayList<>();
        items.add(new LocalGridItem("Campo Grande", "07:00 - 22:00", "Abrindo mapa de Campo Grande"));
        items.add(new LocalGridItem("Nova Andradina", "07:00 - 22:00", "Abrindo mapa de Nova Andradina"));
        items.add(new LocalGridItem("Caarapó", "08:00 - 22:00", "Abrindo mapa de Caarapó"));
        items.add(new LocalGridItem("Dourados", "10:00 - 23:00", "Abrindo mapa de Dourados"));
        items.add(new LocalGridItem("Naviraí", "10:00 - 23:00", "Abrindo mapa de Naviraí"));
        items.add(new LocalGridItem("Deodápolis", "10:00 - 23:00", "Abrindo mapa de Deodápolis"));

        GridView grid = (GridView) view.findViewById(R.id.locaisGridView);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LocalGridItem itemSelecionado = items.get(position);
                Toast.makeText(getContext(), itemSelecionado.getMensagemClick(), Toast.LENGTH_SHORT).show();
                String locationQuery = itemSelecionado.getNomeLocal().concat(", MS"); // Replace this with the location you want to search for
                String geoUri = "geo:0,0?q=" + Uri.encode(locationQuery);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        grid.setAdapter(new AdaptadorLocalGrid(getContext(), items));

        return view;
    }
}