package com.busenamli.matchinggame;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class MemoryImageView extends androidx.appcompat.widget.AppCompatImageView {

    boolean cardBack = true;
    boolean isMatched = false;

    public MemoryImageView(Context context) {
        super(context);
    }
}
