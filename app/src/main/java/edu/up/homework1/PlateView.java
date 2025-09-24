package edu.up.homework1;
/**
Name: Daniel Nguyen
 Date: 9/17/25
 CS-301 Homework 1a
*/


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PlateView extends SurfaceView implements View.OnTouchListener{

    private ArrayList<Item> items;
    private ArrayList<Item.type> typeItems;   // setting up a second array list with type Item.type for drawing dots
    private int index = 0; // index for iterating through newItems

    public PlateView(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);

        items = new ArrayList<>();
        Item s1 = new Item(500, 550, Item.type.redDot);
        Item s2 = new Item(670, 580, Item.type.greenDot);
        Item s3 = new Item(700, 400, Item.type.blueDot);
        Item s4 = new Item(800, 350, Item.type.blackDot);
        Item s5 = new Item(900, 620, Item.type.yellowDot);
        Item s6 = new Item(1000, 250, Item.type.pinkDot);
        Item s7 = new Item(1100, 380, Item.type.grayDot);
        Item foodPlate = new Item(1000,600, Item.type.plate);
        items.add(foodPlate);
        items.add(s1);
        items.add(s2);
        items.add(s3);
        items.add(s4);
        items.add(s5);
        items.add(s6);
        items.add(s7);

        //I believe this is a very inefficient way of doing this,
        // but I am unsure how to do it better
        typeItems = new ArrayList<>();
        typeItems.add(Item.type.redDot);
        typeItems.add(Item.type.greenDot);
        typeItems.add(Item.type.blueDot);
        typeItems.add(Item.type.blackDot);
        typeItems.add(Item.type.yellowDot);
        typeItems.add(Item.type.pinkDot);
        typeItems.add(Item.type.grayDot);


        this.setOnTouchListener(this);


    }
    @Override
    public void onDrawForeground(@NonNull Canvas canvas) {
        super.onDrawForeground(canvas);

        for (Item s : items) {
            s.draw(canvas);
        }

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();


            Item.type t = typeItems.get(index); //set t as an item in the array at i
            index++;
            if (index >= typeItems.size()) { //if reached the end of list, cycle back to 0
                index = 0;
            }
            Item s = new Item(x, y, t);
            items.add(s);

            invalidate();
            return true;
        }

        return false;

    }
}
