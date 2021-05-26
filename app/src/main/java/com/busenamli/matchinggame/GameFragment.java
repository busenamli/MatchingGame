package com.busenamli.matchinggame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GameFragment extends Fragment {

    String category;
    int difficulty;
    int score = 0;
    boolean cardBack = true;
    int clicked = 0;
    int lastClicked = -1;
    int cardNo;
    ImageView imageView;
    String scoreTxt;
    Handler handler;
    Runnable runnable;

    TextView scoreText, timeText;

    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11,
            imageView12, imageView13, imageView14, imageView15, imageView16, imageView17, imageView18, imageView19, imageView20;

    ImageView imageView1Icon, imageView2Icon, imageView3Icon, imageView4Icon, imageView5Icon, imageView6Icon, imageView7Icon, imageView8Icon, imageView9Icon,
            imageView10Icon, imageView11Icon, imageView12Icon, imageView13Icon, imageView14Icon, imageView15Icon, imageView16Icon, imageView17Icon, imageView18Icon,
            imageView19Icon, imageView20Icon;

    ImageView[] imageViewListEasy, imageViewListMedium, imageViewListHard;
    ImageView[] imageViewListIcon;
    Integer[] cartoonList;
    CardLists cardLists;

    public GameFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance(String param1, String param2) {
        GameFragment fragment = new GameFragment();
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
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null){
            category = GameFragmentArgs.fromBundle(getArguments()).getCategory();
            difficulty = GameFragmentArgs.fromBundle(getArguments()).getDifficulty();
        }

        init(view);

        if(difficulty == Constants.EASY){

            if (category.equals(Constants.CARTOON)) {

                cartoonList = cardLists.easyCartoonList();
                //ArrayList<Integer> cardNo = new ArrayList<>();

                for (int i = 0; i < imageViewListEasy.length; i++){

                    int index = i;
                    //cardNo = cartoonList[i];
                    //imageView = imageViewListEasy[i];

                    imageViewListEasy[index].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            System.out.println("imageViewListEasy[index].getResources().toString():" + imageViewListEasy[index].getResources().toString());

                            if (!imageViewListEasy[index].toString().equals(cartoonList[index].toString()) && clicked < 2) {

                                imageViewListEasy[index].setImageResource(cartoonList[index]);
                                imageViewListEasy[index].setClickable(false);

                                if (clicked == 0) {
                                    lastClicked = index;
                                }
                                clicked += 1;

                            }/*else if(imageViewListEasy[index].toString().equals(cartoonList[index].toString())){
                                imageViewListEasy[index].setImageResource(cartoonList[index]);
                                clicked--;
                            }*/

                            if (clicked == 2) {

                                //imageViewListEasy[index].setImageResource(cartoonList[index]);
                                //imageViewListEasy[lastClicked].setImageResource(cartoonList[lastClicked]);

                                System.out.println(cartoonList[index].toString() + " + " + cartoonList[lastClicked]);

                                if (cartoonList[index].toString().equals(cartoonList[lastClicked].toString())) {

                                    //imageViewListEasy[index].setImageResource(cartoonList[index]);
                                    //imageViewListEasy[lastClicked].setImageResource(cartoonList[lastClicked]);

                                    imageViewListIcon[index].setVisibility(View.VISIBLE);
                                    imageViewListIcon[lastClicked].setVisibility(View.VISIBLE);

                                    imageViewListIcon[index].setImageResource(R.drawable.ic_true);
                                    imageViewListIcon[lastClicked].setImageResource(R.drawable.ic_true);

                                    imageViewListEasy[index].setClickable(false);
                                    imageViewListEasy[lastClicked].setClickable(false);

                                    score += 1;
                                    scoreTxt = String.valueOf(score);
                                    scoreText.setText("PUAN: " + scoreTxt);

                                }else{

                                    /*runnable = new Runnable() {
                                        @Override
                                        public void run() {

                                            imageViewListIcon[index].setVisibility(View.VISIBLE);
                                            imageViewListIcon[lastClicked].setVisibility(View.VISIBLE);

                                            imageViewListIcon[index].setImageResource(R.drawable.ic_false);
                                            imageViewListIcon[lastClicked].setImageResource(R.drawable.ic_false);

                                            handler.postDelayed(this,1000);
                                        }
                                    };

                                    handler.post(runnable);*/
                                    imageViewListEasy[index].setClickable(true);
                                    imageViewListEasy[lastClicked].setClickable(true);

                                    imageViewListEasy[index].setImageResource(cartoonList[index]);
                                    imageViewListEasy[lastClicked].setImageResource(cartoonList[lastClicked]);

                                    imageViewListIcon[index].setVisibility(View.VISIBLE);
                                    imageViewListIcon[lastClicked].setVisibility(View.VISIBLE);

                                    imageViewListIcon[index].setImageResource(R.drawable.ic_false);
                                    imageViewListIcon[lastClicked].setImageResource(R.drawable.ic_false);

                                    imageViewListEasy[index].setImageResource(R.drawable.kart_arka);
                                    imageViewListEasy[lastClicked].setImageResource(R.drawable.kart_arka);

                                    imageViewListIcon[index].setVisibility(View.INVISIBLE);
                                    imageViewListIcon[lastClicked].setVisibility(View.INVISIBLE);
                                }

                                /*else {

                                    imageViewListEasy[index].setImageResource(cartoonList[index]);
                                    imageViewListEasy[lastClicked].setImageResource(cartoonList[lastClicked]);

                                    imageViewListEasy[index].setImageResource(R.drawable.kart_arka);
                                    imageViewListEasy[lastClicked].setImageResource(R.drawable.kart_arka);
                                }*/

                                lastClicked = -1;
                                clicked = 0;

                            } /*else{
                                imageViewListEasy[index].setImageResource(R.drawable.kart_arka);
                                imageViewListEasy[lastClicked].setImageResource(R.drawable.kart_arka);
                                lastClicked = -1;
                                clicked = 0;
                            }*/
                        }
                    });

                }


                /*for (int i = 0; i < imageViewListEasy.length; i++) {
                    imageViewListEasy[i].setImageResource(cartoonList[i]);
                }*/
            }
        }

        if (difficulty == Constants.MEDIUM || difficulty == Constants.HARD){

            imageView13.setVisibility(View.VISIBLE);
            imageView14.setVisibility(View.VISIBLE);
            imageView15.setVisibility(View.VISIBLE);
            imageView16.setVisibility(View.VISIBLE);

            if (category.equals(Constants.CARTOON)){
                cartoonList = cardLists.mediumCartoonList();

                for(int i = 0; i<imageViewListMedium.length; i++){
                    imageViewListMedium[i].setImageResource(cartoonList[i]);
                }
            }

            if (difficulty == 2){

                imageView17.setVisibility(View.VISIBLE);
                imageView18.setVisibility(View.VISIBLE);
                imageView19.setVisibility(View.VISIBLE);
                imageView20.setVisibility(View.VISIBLE);

                if (category.equals(Constants.CARTOON)){
                    cartoonList = cardLists.hardCartoonList();

                    for(int i = 0; i<imageViewListHard.length; i++){
                        imageViewListHard[i].setImageResource(cartoonList[i]);
                    }
                }

            }
        }


        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Kalan süre: " + millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {
                /*AlertDialog.Builder alert = new AlertDialog.Builder(GameFragment.this.getActivity());

                alert.setTitle("OYUN BİTTİ");
                alert.setMessage("Puanınız: " + score);
                alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.setNegativeButton("Çık", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(GameFragment.this.getActivity(), "Oyun Bitti!", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();*/
            }
        }.start();
    }


    private void init(View view){

        imageView1 = view.findViewById(R.id.imageView1);
        imageView2 = view.findViewById(R.id.imageView2);
        imageView3 = view.findViewById(R.id.imageView3);
        imageView4 = view.findViewById(R.id.imageView4);
        imageView5 = view.findViewById(R.id.imageView5);
        imageView6 = view.findViewById(R.id.imageView6);
        imageView7 = view.findViewById(R.id.imageView7);
        imageView8 = view.findViewById(R.id.imageView8);
        imageView9 = view.findViewById(R.id.imageView9);
        imageView10 = view.findViewById(R.id.imageView10);
        imageView11 = view.findViewById(R.id.imageView11);
        imageView12 = view.findViewById(R.id.imageView12);
        imageView13 = view.findViewById(R.id.imageView13);
        imageView14 = view.findViewById(R.id.imageView14);
        imageView15 = view.findViewById(R.id.imageView15);
        imageView16 = view.findViewById(R.id.imageView16);
        imageView17 = view.findViewById(R.id.imageView17);
        imageView18 = view.findViewById(R.id.imageView18);
        imageView19 = view.findViewById(R.id.imageView19);
        imageView20 = view.findViewById(R.id.imageView20);

        imageView1Icon = view.findViewById(R.id.imageView1_icon);
        imageView2Icon = view.findViewById(R.id.imageView2_icon);
        imageView3Icon = view.findViewById(R.id.imageView3_icon);
        imageView4Icon = view.findViewById(R.id.imageView4_icon);
        imageView5Icon = view.findViewById(R.id.imageView5_icon);
        imageView6Icon = view.findViewById(R.id.imageView6_icon);
        imageView7Icon = view.findViewById(R.id.imageView7_icon);
        imageView8Icon = view.findViewById(R.id.imageView8_icon);
        imageView9Icon = view.findViewById(R.id.imageView9_icon);
        imageView10Icon = view.findViewById(R.id.imageView10_icon);
        imageView11Icon = view.findViewById(R.id.imageView11_icon);
        imageView12Icon = view.findViewById(R.id.imageView12_icon);
        imageView13Icon = view.findViewById(R.id.imageView13_icon);
        imageView14Icon = view.findViewById(R.id.imageView14_icon);
        imageView15Icon = view.findViewById(R.id.imageView15_icon);
        imageView16Icon = view.findViewById(R.id.imageView16_icon);
        imageView17Icon = view.findViewById(R.id.imageView17_icon);
        imageView18Icon = view.findViewById(R.id.imageView18_icon);
        imageView19Icon = view.findViewById(R.id.imageView19_icon);
        imageView20Icon = view.findViewById(R.id.imageView20_icon);

        scoreText = view.findViewById(R.id.game_score_text);
        timeText = view.findViewById(R.id.game_time);

        imageViewListEasy = new ImageView[]{imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11,
                imageView12};

        imageViewListMedium = new ImageView[]{imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11,
                imageView12, imageView13, imageView14, imageView15, imageView16};

        imageViewListHard = new ImageView[]{imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11,
                imageView12, imageView13, imageView14, imageView15, imageView16, imageView17, imageView18, imageView19, imageView20};

        imageViewListIcon = new ImageView[]{imageView1Icon, imageView2Icon, imageView3Icon, imageView4Icon, imageView5Icon, imageView6Icon, imageView7Icon, imageView8Icon, imageView9Icon,
                imageView10Icon, imageView11Icon, imageView12Icon, imageView13Icon, imageView14Icon, imageView15Icon, imageView16Icon, imageView17Icon,
                imageView18Icon, imageView19Icon, imageView20Icon};

        handler = new Handler();

        cardLists = new CardLists();

    }

}