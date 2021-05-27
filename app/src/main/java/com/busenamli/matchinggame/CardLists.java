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

    private Integer[] emojiList = {drawable.emoji1, drawable.emoji2, drawable.emoji3, drawable.emoji4, drawable.emoji5, drawable.emoji6,
            drawable.emoji7, drawable.emoji8, drawable.emoji9, drawable.emoji10, drawable.emoji11, drawable.emoji12, drawable.emoji13,
            drawable.emoji14, drawable.emoji15, drawable.emoji16, drawable.emoji17, drawable.emoji18, drawable.emoji19, drawable.emoji20};

    private Integer[] animalList = {drawable.animal1, drawable.animal2, drawable.animal3, drawable.animal4, drawable.animal5, drawable.animal6,
            drawable.animal7, drawable.animal8, drawable.animal9, drawable.animal10, drawable.animal11, drawable.animal12, drawable.animal13,
            drawable.animal14, drawable.animal15, drawable.animal16, drawable.animal17, drawable.animal18, drawable.animal19, drawable.animal20};

    private Integer[] mixedCartoonList = cardShuffle(cartoonList);
    private Integer[] mixedEmojiList = cardShuffle(emojiList);
    private Integer[] mixedAnimalList = cardShuffle(animalList);

    Integer[] mixedList;

    private Integer[] easyList = new Integer[6];
    private Integer[] easyListMix = new Integer[12];

    private Integer[] mediumList = new Integer[8];
    private Integer[] mediumListMix = new Integer[16];

    private Integer[] hardList = new Integer[10];
    private Integer[] hardListMix = new Integer[20];

    private Integer[] cardShuffle(Integer[] cardList){

        List<Integer> cards = Arrays.asList(cardList);
        Collections.shuffle(cards);
        cards.toArray(cardList);
        return cardList;
    }

    public Integer[] easyCartoonList(String category){

        if (category.equals(Constants.CARTOON)){
            mixedList = mixedCartoonList;

        } else if (category.equals(Constants.EMOJI)){
            mixedList = mixedEmojiList;

        } else if (category.equals(Constants.ANIMAL)){
            mixedList = mixedAnimalList;
        }

        for(int i=0; i<easyList.length; i++){
            easyList[i] = mixedList[i];
        }

        for(int i=0; i<easyListMix.length; i++){
            easyListMix[i] = easyList[i%6];
        }

        return cardShuffle(easyListMix);
    }

    public Integer[] mediumCartoonList(String category){

        if (category.equals(Constants.CARTOON)){
            mixedList = mixedCartoonList;

        } else if (category.equals(Constants.EMOJI)){
            mixedList = mixedEmojiList;

        } else if (category.equals(Constants.ANIMAL)){
            mixedList = mixedAnimalList;
        }

        for(int i=0; i<mediumList.length; i++){
            mediumList[i] = mixedList[i];
        }

        for(int i=0; i<mediumListMix.length; i++){
            mediumListMix[i] = mediumList[i%8];
        }

        return cardShuffle(mediumListMix);
    }

    public Integer[] hardCartoonList(String category){

        if (category.equals(Constants.CARTOON)){
            mixedList = mixedCartoonList;

        } else if (category.equals(Constants.EMOJI)){
            mixedList = mixedEmojiList;

        } else if (category.equals(Constants.ANIMAL)){
            mixedList = mixedAnimalList;
        }

        for(int i=0; i<hardList.length; i++){
            hardList[i] = mixedList[i];
        }

        for(int i=0; i<hardListMix.length; i++){
            hardListMix[i] = hardList[i%10];
        }

        return cardShuffle(hardListMix);
    }
}
