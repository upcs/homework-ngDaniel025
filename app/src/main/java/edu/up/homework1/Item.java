package edu.up.homework1;
/**
 @author Daniel Nguyen
 Date: 9/17/25
 CS-301 Homework 1a
 */

import android.graphics.Canvas;
import android.graphics.Paint;

public class Item {

    enum type{
        plate, redDot, blueDot, greenDot, blackDot, pinkDot, yellowDot, grayDot;
    }
    private type object;
    private float r,rPlate,cx,cy;
    private Paint white, red, blue, green, black, pink, yellow, gray;

    public Item(float x, float y, type s){
        cx = x;
        cy = y;
        r = 50;
        rPlate = 650; // larger radius for plate

        //assigning the colors, colors.
        white = new Paint();
        white.setARGB(255,255,255,255);

        black = new Paint();
        black.setARGB(255,0,0,0);

        red = new Paint();
        red.setARGB(255,255,1,1);

        blue = new Paint();
        blue.setARGB(255,0,0,255);

        green = new Paint();
        green.setARGB(255,0,255,0);

        pink = new Paint();
        pink.setARGB( 255,255,192,203);

        yellow = new Paint();
        yellow.setARGB(255,255, 255, 0);

        gray = new Paint();
        gray.setARGB(255,128, 128, 128);

        object = s;

    }

    public void draw(Canvas canvas){

        //creating the different type of dots as well as the plate
        switch(object){
            case plate:
                canvas.drawCircle(cx,cy,rPlate, white);
                break;
            case redDot:
                canvas.drawCircle(cx,cy,75, red);
                break;
            case greenDot:
                canvas.drawCircle(cx, cy,85,green);
                break;
            case blueDot:
                canvas.drawCircle(cx,cy,60,blue);
                break;
            case blackDot:
                canvas.drawCircle(cx,cy,r,black);
                break;
            case pinkDot:
                canvas.drawCircle(cx,cy,r,pink);
                break;
            case yellowDot:
                canvas.drawCircle(cx,cy,30,yellow);
                break;

            case grayDot:
                canvas.drawCircle(cx,cy,r,gray);
                break;
        }


    }
}
