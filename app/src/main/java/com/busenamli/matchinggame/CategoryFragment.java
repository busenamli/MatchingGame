package com.busenamli.matchinggame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;


public class CategoryFragment extends Fragment {

    Button categoryCartoonButton, categoryVegetableButton, categoryFruitButton;
    private View.OnClickListener mOnClickListener;

    static final String CARTOON = "cartoon";
    static final String VEGETABLE = "vegetable";
    static final String FRUIT = "fruit";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoryFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
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
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categoryCartoonButton = view.findViewById(R.id.category_cartoon_button);
        categoryVegetableButton = view.findViewById(R.id.category_vegetable_button);
        categoryFruitButton = view.findViewById(R.id.category_fruit_button);

        buttonsClickHandle();

    }

    private void buttonsClickHandle(){

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = v.getId();
                switch (id) {
                    case R.id.category_cartoon_button:

                        CategoryFragmentDirections.ActionCategoryFragmentToDifficultyLevelFragment actionCartoon = CategoryFragmentDirections.actionCategoryFragmentToDifficultyLevelFragment(CARTOON);
                        actionCartoon.setCategoryName(CARTOON);
                        Navigation.findNavController(v).navigate(actionCartoon);

                        break;
                    case R.id.category_vegetable_button:

                        CategoryFragmentDirections.ActionCategoryFragmentToDifficultyLevelFragment actionVegetable = CategoryFragmentDirections.actionCategoryFragmentToDifficultyLevelFragment(VEGETABLE);
                        actionVegetable.setCategoryName(VEGETABLE);
                        Navigation.findNavController(v).navigate(actionVegetable);

                        break;
                    case R.id.category_fruit_button:

                        CategoryFragmentDirections.ActionCategoryFragmentToDifficultyLevelFragment actionFruit = CategoryFragmentDirections.actionCategoryFragmentToDifficultyLevelFragment(FRUIT);
                        actionFruit.setCategoryName(FRUIT);
                        Navigation.findNavController(v).navigate(actionFruit);

                        break;
                }
            }
        };
    }
}