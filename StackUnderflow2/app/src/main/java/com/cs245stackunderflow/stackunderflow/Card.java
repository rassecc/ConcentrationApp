/***************************************************************
 * file: Card.java
 * author: Nick Curinga, Devin Wells, Caesar Pedroza, Tuan
 * class: CS 245
 – Programming Graphical User Interfaces
 *
 * assignment: Android App
 * date last modified: 11/29/2016
 *
 * purpose: This class is a card.
 ****************************************************************/

package com.cs245stackunderflow.stackunderflow;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;
import android.widget.GridLayout;

public class Card extends Button {

    private int cardID;
    private Drawable frontSide;
    private Drawable backSide;
    private boolean isFaceUp;

    public Card(Context c,int id)
    {
     super(c);

     frontSide = AppCompatDrawableManager.get().getDrawable(c,id);
     backSide = AppCompatDrawableManager.get().getDrawable(c,R.drawable.card);

        cardID = id;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(backSide);
        }

        GridLayout.LayoutParams glp = new GridLayout.LayoutParams();

        glp.width = (int)getResources().getDisplayMetrics().density*52;
        glp.height = (int)getResources().getDisplayMetrics().density*49;
        setLayoutParams(glp);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void flip()
    {
        if(isFaceUp()) {
            setBackground(backSide);
            setFaceUp(false);
        }
        else
        {
            setBackground(frontSide);
            setFaceUp(true);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void show()
    {
        setBackground(frontSide);
        setFaceUp(true);

    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public int getCardID() {
        return cardID;
    }




}
