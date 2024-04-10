package com.example.digiwagen;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.digiwagen.databinding.FragmentHomepageBinding;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment {

    private FragmentHomepageBinding binding;
    private MediaPlayer mediaPlayer;
    private boolean foiReleased = true;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHomepageBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        List<CarListItem> carListItems = CarMockBuilder.build();

        binding.carsListView.setAdapter(new AdaptadorCarList(getContext(), carListItems));


        binding.carsListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        CarListItem clickedItem = carListItems.get(position);
                        Bundle bundle = new Bundle();

                        bundle.putSerializable("carro_escolhido", clickedItem);

                        NavHostFragment.findNavController(HomePageFragment.this)
                                .navigate(R.id.action_FirstFragment_to_CarDetailFragment, bundle);
                        if (foiReleased) {
                            mediaPlayer = MediaPlayer.create(getContext(), R.raw.som_motor_iniciando);
                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp.release();
                                    foiReleased = true;
                                }
                            });
                            foiReleased = false;
                        }
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            foiReleased = true;
                        } else {
                            mediaPlayer.start();
                        }
                    }
                }
        );
        return root;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(HomePageFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}