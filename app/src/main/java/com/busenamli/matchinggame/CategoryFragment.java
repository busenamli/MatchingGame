package com.busenamli.matchinggame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;


public class CategoryFragment extends Fragment {

    Button categoryCartoonButton, categoryEmojiButton, categoryAnimalButton, categoryTransportButton;

    public CategoryFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        //getActivity().setTitle(R.string.category_fragment_label);

        categoryCartoonButton = view.findViewById(R.id.category_cartoon_button);
        categoryEmojiButton = view.findViewById(R.id.category_emoji_button);
        categoryAnimalButton = view.findViewById(R.id.category_animal_button);
        categoryTransportButton = view.findViewById(R.id.category_transport_button);

        categoryCartoonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CategoryFragmentDirections.ActionCategoryFragmentToDifficultyLevelFragment actionCartoon = CategoryFragmentDirections.actionCategoryFragmentToDifficultyLevelFragment(Constants.CARTOON);
                actionCartoon.setCategoryName(Constants.CARTOON);
                Navigation.findNavController(v).navigate(actionCartoon);
            }
        });

        categoryEmojiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryFragmentDirections.ActionCategoryFragmentToDifficultyLevelFragment actionEmoji = CategoryFragmentDirections.actionCategoryFragmentToDifficultyLevelFragment(Constants.EMOJI);
                actionEmoji.setCategoryName(Constants.EMOJI);
                Navigation.findNavController(v).navigate(actionEmoji);
            }
        });

        categoryAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryFragmentDirections.ActionCategoryFragmentToDifficultyLevelFragment actionAnimal = CategoryFragmentDirections.actionCategoryFragmentToDifficultyLevelFragment(Constants.ANIMAL);
                actionAnimal.setCategoryName(Constants.ANIMAL);
                Navigation.findNavController(v).navigate(actionAnimal);
            }
        });

        categoryTransportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CategoryFragmentDirections.ActionCategoryFragmentToDifficultyLevelFragment actionTransport = CategoryFragmentDirections.actionCategoryFragmentToDifficultyLevelFragment(Constants.TRANSPORT);
                actionTransport.setCategoryName(Constants.TRANSPORT);
                Navigation.findNavController(v).navigate(actionTransport);

            }
        });

    }
}