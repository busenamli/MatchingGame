package com.busenamli.matchinggame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class GameFragment extends Fragment{

    private static final String ARG_CATEGORY = "category";
    private static final String ARG_DIFFICULTY = "difficulty";

    String category;
    int difficulty;
    int score = 0;
    int clicked = 0;
    int lastClicked = -1;
    Handler handler;
    ArrayList<Integer> matchList;

    CountDownTimer timer;

    TextView scoreText, timeText, plusScoreText;

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

    MediaPlayer mpCorrect;
    MediaPlayer mpWrong;

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

        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        getActivity().setTitle("");

        if (getArguments() != null){
            category = GameFragmentArgs.fromBundle(getArguments()).getCategory();
            difficulty = GameFragmentArgs.fromBundle(getArguments()).getDifficulty();
        }

        mpCorrect = MediaPlayer.create(GameFragment.this.getActivity().getApplicationContext(), R.raw.zapsplat_correct_tone);
        mpWrong = MediaPlayer.create(GameFragment.this.getActivity().getApplicationContext(), R.raw.zapsplat_wrong_tone);

        init(view);

        game(category, difficulty,cardLists);

        timer = new CountDownTimer(150000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                NumberFormat f = new DecimalFormat("00");

                long minute = (millisUntilFinished / 60000) % 60;
                long second = (millisUntilFinished / 1000) % 60;

                timeText.setText("Kalan süre: " + f.format(minute) + ":" + f.format(second));

            }

            @Override
            public void onFinish() {

                timeText.setText("Kalan süre: 00:00");

                showDialog(timeText.getText().toString().substring(11));

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
        plusScoreText = view.findViewById(R.id.game_plus_score_text);
        plusScoreText.setVisibility(View.INVISIBLE);

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

    @Override
    public void onStop() {
        super.onStop();
        timer.cancel();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        timer.cancel();
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        timer.cancel();
    }

    public void game(String cat, int diff, CardLists cards){

        if(diff == Constants.EASY){

            if (cat.equals(Constants.CARTOON)) {

                cardList = cards.easyCartoonList(Constants.CARTOON);
                imageViewList = imageViewListEasy;

            }

            if (cat.equals(Constants.EMOJI)) {

                cardList = cards.easyCartoonList(Constants.EMOJI);
                imageViewList = imageViewListEasy;

            }

            if (cat.equals(Constants.ANIMAL)) {

                cardList = cards.easyCartoonList(Constants.ANIMAL);
                imageViewList = imageViewListEasy;

            }

            if (cat.equals(Constants.TRANSPORT)) {

                cardList = cards.easyCartoonList(Constants.TRANSPORT);
                imageViewList = imageViewListEasy;

            }
        }

        if (diff == Constants.MEDIUM || diff == Constants.HARD){

            imageView13.setVisibility(View.VISIBLE);
            imageView14.setVisibility(View.VISIBLE);
            imageView15.setVisibility(View.VISIBLE);
            imageView16.setVisibility(View.VISIBLE);

            if (cat.equals(Constants.CARTOON)){

                cardList = cards.mediumCartoonList(Constants.CARTOON);
                imageViewList = imageViewListMedium;
            }

            if (cat.equals(Constants.EMOJI)){

                cardList = cards.mediumCartoonList(Constants.EMOJI);
                imageViewList = imageViewListMedium;
            }

            if (cat.equals(Constants.ANIMAL)){

                cardList = cards.mediumCartoonList(Constants.ANIMAL);
                imageViewList = imageViewListMedium;
            }

            if (cat.equals(Constants.TRANSPORT)){

                cardList = cards.mediumCartoonList(Constants.TRANSPORT);
                imageViewList = imageViewListMedium;
            }

            if (diff == 2){

                imageView17.setVisibility(View.VISIBLE);
                imageView18.setVisibility(View.VISIBLE);
                imageView19.setVisibility(View.VISIBLE);
                imageView20.setVisibility(View.VISIBLE);

                if (cat.equals(Constants.CARTOON)){

                    cardList = cards.hardCartoonList(Constants.CARTOON);
                    imageViewList = imageViewListHard;

                }

                if (cat.equals(Constants.EMOJI)){

                    cardList = cards.hardCartoonList(Constants.EMOJI);
                    imageViewList = imageViewListHard;

                }

                if (cat.equals(Constants.ANIMAL)){

                    cardList = cards.hardCartoonList(Constants.ANIMAL);
                    imageViewList = imageViewListHard;

                }

                if (cat.equals(Constants.TRANSPORT)){

                    cardList = cards.hardCartoonList(Constants.TRANSPORT);
                    imageViewList = imageViewListHard;

                }

            }
        }

        gameDetails(cardList, imageViewList);
    }

    public void gameDetails(Integer[] cardList, ImageView[] imageViewList){

        matchList = new ArrayList<>();

        for (int i = 0; i < imageViewList.length; i++) {

            int index = i;

            imageViewList[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clicked++;

                    if (clicked <= 2) {

                        //Bir kere tıklanma
                        if (clicked == 1) {

                            lastClicked = index;
                            changeAnimation(imageViewList[index], cardList[index]);
                            imageViewList[index].setClickable(false);

                        }

                        //2 kere tıklanma
                        if (clicked == 2) {

                            changeAnimation(imageViewList[index], cardList[index]);

                            imageViewList[index].setClickable(false);
                            imageViewList[lastClicked].setClickable(false);

                            //kartlar eşleşiyorsa
                            if (cardList[index].toString().equals(cardList[lastClicked].toString())) {

                                imageViewList[index].setClickable(false);
                                imageViewList[lastClicked].setClickable(false);

                                matchList.add(index);
                                matchList.add(lastClicked);

                                if(difficulty == Constants.EASY){
                                    plusScoreText.setText("+2");
                                    score = score + 2;
                                }

                                if(difficulty == Constants.MEDIUM){
                                    plusScoreText.setText("+4");
                                    score = score + 4;
                                }

                                if (difficulty == Constants.HARD){
                                    plusScoreText.setText("+6");
                                    score = score + 6;
                                }

                                int a = lastClicked;

                                //1sn bekle başarılı animasyonları
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        mpCorrect.start();

                                        imageViewListIcon[index].setVisibility(View.VISIBLE);
                                        imageViewListIcon[a].setVisibility(View.VISIBLE);

                                        imageViewListIcon[index].setImageResource(R.drawable.ic_true);
                                        imageViewListIcon[a].setImageResource(R.drawable.ic_true);

                                        plusScoreText.setVisibility(View.VISIBLE);

                                        //Hepsi eşleşmişse - oyun bittiyse
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                scoreText.setText("PUAN: " + score);
                                                plusScoreText.setVisibility(View.INVISIBLE);
                                                ArrayList<Integer> visibilityList = new ArrayList<>();

                                                for (int k = 0; k < imageViewList.length; k++){
                                                    if(imageViewListIcon[k].getVisibility() == View.VISIBLE){
                                                        visibilityList.add(k);
                                                    }
                                                }

                                                if(visibilityList.size() == imageViewList.length){

                                                    timer.cancel();
                                                    showDialog(timeText.getText().toString().substring(11));
                                                }

                                            }
                                        },1000);
                                    }
                                }, 1000);

                            } else {

                                for (ImageView imageView : imageViewList) {
                                    imageView.setClickable(false);
                                }

                                int b = lastClicked;

                                //1sn bekle başarısız animasyonları
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        mpWrong.start();

                                        imageViewListIcon[index].setVisibility(View.VISIBLE);
                                        imageViewListIcon[b].setVisibility(View.VISIBLE);

                                        imageViewListIcon[index].setImageResource(R.drawable.ic_false);
                                        imageViewListIcon[b].setImageResource(R.drawable.ic_false);

                                        /*if(difficulty == Constants.MEDIUM){
                                            plusScoreText.setVisibility(View.VISIBLE);
                                            plusScoreText.setText("-1");
                                            score = score - 1;
                                        }
                                        if (difficulty == Constants.HARD){
                                            plusScoreText.setVisibility(View.VISIBLE);
                                            plusScoreText.setText("-2");
                                            score = score - 2;
                                        }

                                        scoreText.setText("PUAN: " + score);*/

                                        //1sn bekle kartları kapat
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                imageViewListIcon[index].setVisibility(View.INVISIBLE);
                                                imageViewListIcon[b].setVisibility(View.INVISIBLE);
                                                System.out.println("b: " + b);

                                                changeAnimation(imageViewList[index], R.drawable.kart_arka);
                                                changeAnimation(imageViewList[b], R.drawable.kart_arka);

                                                for (int j = 0; j < imageViewList.length; j++) {
                                                    if (!matchList.contains(j)) {
                                                        imageViewList[j].setClickable(true);
                                                    }
                                                }
                                                plusScoreText.setVisibility(View.INVISIBLE);
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

    //http://ahmetardahanli.com/android-custom-alert-dialog-kullanimi
    private void showDialog(String lastTime){

        mpCorrect.stop();
        mpWrong.stop();

        Dialog dialog = new Dialog(GameFragment.this.getContext());

        final View customLayout
                = getLayoutInflater()
                .inflate(
                        R.layout.custom_dialog,
                        null);

        dialog.setContentView(customLayout);

        Button againButton = customLayout.findViewById(R.id.button_again);
        Button exitButton = customLayout.findViewById(R.id.button_exit);
        TextView scoreTextView = customLayout.findViewById(R.id.textview_score);
        TextView timeTextView = customLayout.findViewById(R.id.textview_time);

        scoreTextView.setText("PUAN: " + score);
        timeTextView.setText("KALAN SÜRE: " + lastTime);

        againButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Bundle args = new Bundle();
                args.putString(ARG_CATEGORY, category);
                args.putInt(ARG_DIFFICULTY, difficulty);
                Fragment fragment = new GameFragment();
                fragment.setArguments(args);
                ft.replace(R.id.nav_host_fragment, fragment).commit();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

                NavDirections action = GameFragmentDirections.actionGameFragmentToStartFragment();
                Navigation.findNavController(getView()).navigate(action);
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }
}