package com.busenamli.matchinggame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;

public class DifficultyLevelFragment extends Fragment {

    Button difficultyEasyButton, difficultyMediumButton, difficultyHardButton;
    String category;

    public DifficultyLevelFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DifficultyLevelFragment newInstance(String param1, String param2) {
        DifficultyLevelFragment fragment = new DifficultyLevelFragment();
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
        return inflater.inflate(R.layout.fragment_difficulty_level, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity)getActivity()).getSupportActionBar().show();

        if (getArguments() != null){
            category = DifficultyLevelFragmentArgs.fromBundle(getArguments()).getCategoryName();
        }

        difficultyEasyButton = view.findViewById(R.id.difficulty_easy_button);
        difficultyMediumButton = view.findViewById(R.id.difficulty_medium_button);
        difficultyHardButton = view.findViewById(R.id.difficulty_hard_button);

        difficultyEasyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DifficultyLevelFragmentDirections.ActionDifficultyLevelFragmentToGameFragment actionEasy = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToGameFragment(category,Constants.EASY);
                actionEasy.setCategory(category);
                actionEasy.setDifficulty(Constants.EASY);
                Navigation.findNavController(v).navigate(actionEasy);

            }
        });

        difficultyMediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DifficultyLevelFragmentDirections.ActionDifficultyLevelFragmentToGameFragment actionMedium = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToGameFragment(category,Constants.MEDIUM);
                actionMedium.setCategory(category);
                actionMedium.setDifficulty(Constants.MEDIUM);
                Navigation.findNavController(v).navigate(actionMedium);

            }
        });

        difficultyHardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DifficultyLevelFragmentDirections.ActionDifficultyLevelFragmentToGameFragment actionHard = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToGameFragment(category,Constants.HARD);
                actionHard.setCategory(category);
                actionHard.setDifficulty(Constants.HARD);
                Navigation.findNavController(v).navigate(actionHard);

            }
        });

    }
}