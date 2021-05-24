package com.busenamli.matchinggame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private View.OnClickListener mOnClickListener;

    /*static final String EASY = "easy";
    static final String MEDIUM = "medium";
    static final String HARD = "hard";*/

    static final int EASY = 0;
    static final int MEDIUM = 1;
    static final int HARD = 2;

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

        if (getArguments() != null){
            category = DifficultyLevelFragmentArgs.fromBundle(getArguments()).getCategoryName();
        }

        difficultyEasyButton = view.findViewById(R.id.difficulty_easy_button);
        difficultyMediumButton = view.findViewById(R.id.difficulty_medium_button);
        difficultyHardButton = view.findViewById(R.id.difficulty_hard_button);

        buttonsClickHandle();

    }

    private void buttonsClickHandle() {

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = v.getId();
                switch (id) {
                    case R.id.difficulty_easy_button:

                        /*DifficultyLevelFragmentDirections.ActionDifficultyLevelFragmentToEasyGameFragment actionEasy = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToEasyGameFragment(category);
                        actionEasy.setCategory(category);
                        Navigation.findNavController(v).navigate(actionEasy);*/

                        DifficultyLevelFragmentDirections.ActionDifficultyLevelFragmentToGameFragment actionEasy = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToGameFragment(category,EASY);
                        actionEasy.setCategory(category);
                        actionEasy.setDifficulty(EASY);
                        Navigation.findNavController(v).navigate(actionEasy);

                        /*NavDirections actionEasy = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToEasyGameFragment();
                        Navigation.findNavController(view).navigate(actionEasy);*/

                        break;
                    case R.id.difficulty_medium_button:

                        /*DifficultyLevelFragmentDirections.ActionDifficultyLevelFragmentToMediumGameFragment actionMedium = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToMediumGameFragment(category);
                        actionMedium.setCategory(category);
                        Navigation.findNavController(v).navigate(actionMedium);*/

                        DifficultyLevelFragmentDirections.ActionDifficultyLevelFragmentToGameFragment actionMedium = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToGameFragment(category,MEDIUM);
                        actionMedium.setCategory(category);
                        actionMedium.setDifficulty(MEDIUM);
                        Navigation.findNavController(v).navigate(actionMedium);

                        /*NavDirections actionMedium = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToMediumGameFragment();
                        Navigation.findNavController(view).navigate(actionMedium);*/

                        break;
                    case R.id.difficulty_hard_button:

                        /*DifficultyLevelFragmentDirections.ActionDifficultyLevelFragmentToHardGameFragment actionHard = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToHardGameFragment(category);
                        actionHard.setCategory(category);
                        Navigation.findNavController(v).navigate(actionHard);*/

                        DifficultyLevelFragmentDirections.ActionDifficultyLevelFragmentToGameFragment actionHard = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToGameFragment(category,MEDIUM);
                        actionHard.setCategory(category);
                        actionHard.setDifficulty(HARD);
                        Navigation.findNavController(v).navigate(actionHard);

                        /*NavDirections actionHard = DifficultyLevelFragmentDirections.actionDifficultyLevelFragmentToHardGameFragment();
                        Navigation.findNavController(view).navigate(actionHard);*/

                        break;
                }
            }
        };
    }
}