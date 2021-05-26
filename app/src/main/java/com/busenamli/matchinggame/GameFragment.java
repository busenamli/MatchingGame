package com.busenamli.matchinggame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
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
    int clicked = 0;
    int lastClicked = -1;
    Handler handler;
    ArrayList<Integer> matchList;

    TextView scoreText, timeText;

    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11,
            imageView12, imageView13, imageView14, imageView15, imageView16, imageView17, imageView18, imageView19, imageView20;

    ImageView imageView1Icon, imageView2Icon, imageView3Icon, imageView4Icon, imageView5Icon, imageView6Icon, imageView7Icon, imageView8Icon, imageView9Icon,
            imageView10Icon, imageView11Icon, imageView12Icon, imageView13Icon, imageView14Icon, imageView15Icon, imageView16Icon, imageView17Icon, imageView18Icon,
            imageView19Icon, imageView20Icon;

    ImageView[] imageViewListEasy, imageViewListMedium, imageViewListHard;
    ImageView[] imageViewList;
    ImageView[] imageViewListIcon;
    Integer[] cardList;
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

        game(category, difficulty,cardLists);


        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timeText.setText("Kalan süre: " + millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {

                AlertDialog.Builder alert = new AlertDialog.Builder(GameFragment.this.getActivity());

                alert.setTitle("ZAMAN DOLDU");
                alert.setMessage("Puanınız: " + score);
                alert.setPositiveButton("Yeniden Oyna", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Fragment frg = GameFragment.this;
                        //FragmentTransaction ft = (getActivity()).getSupportFragmentManager().beginTransaction();
                        //(getActivity()).getSupportFragmentManager().beginTransaction().detach(GameFragment.this).attach(GameFragment.this).commit();

                        /*Fragment frg = null;
                        frg = getFragmentManager().findFragmentById(R.id.gameFragment);
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.detach(frg);
                        ft.attach(frg);
                        ft.commit();*/

                        /*Fragment frg = getActivity().getSupportFragmentManager().findFragmentById(R.id.gameFragment);
                        FragmentTransaction ft = (getActivity()).getSupportFragmentManager().beginTransaction();
                        ft.detach(frg);
                        ft.attach(frg);
                        ft.commit();*/

                        /*Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.gameFragment);
                        if (currentFragment instanceof com.busenamli.matchinggame.GameFragment){
                            FragmentTransaction fragmentTransaction = (getActivity()).getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.detach(currentFragment);
                            fragmentTransaction.attach(currentFragment);
                            fragmentTransaction.commit();
                        }*/


                    }
                });
                alert.setNegativeButton("Çık", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        NavDirections action = GameFragmentDirections.actionGameFragmentToStartFragment();
                        Navigation.findNavController(view).navigate(action);
                    }
                });

                alert.setCancelable(false);
                alert.show();

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

    public void game(String cat, int diff, CardLists cards){

        if(diff == Constants.EASY){

            if (cat.equals(Constants.CARTOON)) {

                cardList = cards.easyCartoonList();

                imageViewList = imageViewListEasy;

            }
        }

        if (diff == Constants.MEDIUM || diff == Constants.HARD){

            imageView13.setVisibility(View.VISIBLE);
            imageView14.setVisibility(View.VISIBLE);
            imageView15.setVisibility(View.VISIBLE);
            imageView16.setVisibility(View.VISIBLE);

            if (cat.equals(Constants.CARTOON)){

                cardList = cards.mediumCartoonList();

                imageViewList = imageViewListMedium;

                //gameDetails(cardList, imageViewList);

                /*for(int i = 0; i<imageViewList.length; i++){
                    imageViewList[i].setImageResource(cardList[i]);
                }*/
            }

            if (diff == 2){

                imageView17.setVisibility(View.VISIBLE);
                imageView18.setVisibility(View.VISIBLE);
                imageView19.setVisibility(View.VISIBLE);
                imageView20.setVisibility(View.VISIBLE);

                if (cat.equals(Constants.CARTOON)){

                    cardList = cards.hardCartoonList();

                    imageViewList = imageViewListHard;

                }

            }
        }

        gameDetails(cardList, imageViewList);

    }


    public void gameDetails(Integer[] cardList, ImageView[] imageViewList){

        matchList = new ArrayList<>();

        for (int i = 0; i < imageViewList.length; i++){

            int index = i;

            imageViewList[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clicked++;

                    if(clicked<=2) {

                        if (clicked == 1) {

                            lastClicked = index;
                            //imageViewList[index].setImageResource(cardList[index]);
                            changeAnimation(imageViewList[index], cardList[index]);
                            imageViewList[index].setClickable(false);
                        }

                        if (clicked == 2) {

                            //imageViewList[index].setImageResource(cardList[index]);
                            //imageViewList[lastClicked].setImageResource(cardList[lastClicked]);
                            changeAnimation(imageViewList[index], cardList[index]);

                            imageViewList[index].setClickable(false);
                            imageViewList[lastClicked].setClickable(false);

                            if (cardList[index].toString().equals(cardList[lastClicked].toString())) {

                                imageViewList[index].setClickable(false);
                                imageViewList[lastClicked].setClickable(false);

                                matchList.add(index);
                                matchList.add(lastClicked);

                                score += 1;

                                int a = lastClicked;

                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        imageViewListIcon[index].setVisibility(View.VISIBLE);
                                        imageViewListIcon[a].setVisibility(View.VISIBLE);

                                        imageViewListIcon[index].setImageResource(R.drawable.ic_true);
                                        imageViewListIcon[a].setImageResource(R.drawable.ic_true);

                                        scoreText.setText("PUAN: " + score);
                                    }
                                }, 1000);

                            }else{

                                for(ImageView imageView : imageViewList){
                                    imageView.setClickable(false);
                                }

                                int b = lastClicked;

                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        imageViewListIcon[index].setVisibility(View.VISIBLE);
                                        imageViewListIcon[b].setVisibility(View.VISIBLE);

                                        imageViewListIcon[index].setImageResource(R.drawable.ic_false);
                                        imageViewListIcon[b].setImageResource(R.drawable.ic_false);

                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                imageViewListIcon[index].setVisibility(View.INVISIBLE);
                                                imageViewListIcon[b].setVisibility(View.INVISIBLE);
                                                System.out.println("b: " + b);

                                                changeAnimation(imageViewList[index], R.drawable.kart_arka);
                                                changeAnimation(imageViewList[b], R.drawable.kart_arka);

                                                for(int j = 0; j< imageViewList.length; j++){
                                                    if (!matchList.contains(j)) {
                                                        imageViewList[j].setClickable(true);
                                                    }
                                                }
                                            }
                                        }, 1000);

                                    }
                                }, 1000);

                            }

                            lastClicked = -1;
                            clicked = 0;
                        }
                    }
                }
            });

        }
    }

    //https://stackoverflow.com/questions/46111262/card-flip-animation-in-android
    public void changeAnimation(ImageView imageView, int resId){

        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(imageView, "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                imageView.setImageResource(resId);
                oa2.start();
            }
        });
        oa1.start();
    }

}