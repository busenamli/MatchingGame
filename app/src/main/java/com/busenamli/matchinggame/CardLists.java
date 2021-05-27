package com.busenamli.matchinggame;

import com.busenamli.matchinggame.R.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardLists {

    private Integer[] cartoonList = {drawable.cartoon1, drawable.cartoon2, drawable.cartoon3, drawable.cartoon4,
            drawable.cartoon5, drawable.cartoon6, drawable.cartoon7, drawable.cartoon8, drawable.cartoon9,
            drawable.cartoon10, drawable.cartoon11, drawable.cartoon12, drawable.cartoon13, drawable.cartoon14,
            drawable.cartoon15, drawable.cartoon16, drawable.cartoon17, drawable.cartoon18, drawable.cartoon19, drawable.cartoon20};

    private Integer[] mixedCartoonList = cardShuffle(cartoonList);

    private Integer[] easyCartoon = new Integer[6];
    private Integer[] easyCartoonMix = new Integer[12];

    private Integer[] mediumCartoon = new Integer[8];
    private Integer[] mediumCartoonMix = new Integer[16];

    private Integer[] hardCartoon = new Integer[10];
    private Integer[] hardCartoonMix = new Integer[20];

    private Integer[] cardShuffle(Integer[] cardList){

        List<Integer> cards = Arrays.asList(cardList);
        Collections.shuffle(cards);
        cards.toArray(cardList);
        return cardList;
    }

    public Integer[] easyCartoonList(){

        for(int i=0; i<easyCartoon.length; i++){
            easyCartoon[i] = mixedCartoonList[i];
        }

        for(int i=0; i<easyCartoonMix.length; i++){
            easyCartoonMix[i] = easyCartoon[i%6];
        }

        return cardShuffle(easyCartoonMix);
    }

    public Integer[] mediumCartoonList(){

        for(int i=0; i<mediumCartoon.length; i++){
            mediumCartoon[i] = mixedCartoonList[i];
        }

        for(int i=0; i<mediumCartoonMix.length; i++){
            mediumCartoonMix[i] = mediumCartoon[i%8];
        }

        return cardShuffle(mediumCartoonMix);
    }

    public Integer[] hardCartoonList(){

        for(int i=0; i<hardCartoon.length; i++){
            hardCartoon[i] = mixedCartoonList[i];
        }

        for(int i=0; i<hardCartoonMix.length; i++){
            hardCartoonMix[i] = hardCartoon[i%10];
        }

        return cardShuffle(hardCartoonMix);
    }
}
