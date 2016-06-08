package com.anirudh.anirudhswami.delta_2016_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import android.graphics.Matrix;
import android.graphics.Paint;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by Anirudh Swami on 08-06-2016.
 */
public class CanvasJav extends View {

    Bitmap gre_rec;
    int x,y,dx,dy;

    Canvas can;

    //Constructor for the view
    public CanvasJav(Context context){
        super(context);
        gre_rec = BitmapFactory.decodeResource(getResources(), R.mipmap.rect_green);
        x=0;
        y=0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        can = canvas;

        //Go right
        if(dx>0){
            if(x<x+dx){
                x++;
                dx--;
            } else{
                dx=0;
            }
            //Wrap around
            if(x+gre_rec.getWidth()>canvas.getWidth()){
                x=0;
            }
        }
        //Go left
        else if(dx<0){
            if(x>x+dx){
                x--;
                dx++;
            } else{
                dx=0;
            }
            //Wrap around
            if(x<0){
                x=canvas.getWidth()-gre_rec.getWidth();
            }
        }
        //Go down
        if(dy>0){
            if(y<y+dy){
                y++;
                dy--;
            } else{
                dy=0;
            }
            //Wrap around
            if(y+gre_rec.getHeight()>canvas.getHeight()){
                y=0;
            }
        }
        //GO up
        else if (dy<0){
            if(y>y+dy){
                y--;
                dy++;
            } else {
                dy=0;
            }
            //Wrap around
            if(y<0){
                y = canvas.getHeight() - gre_rec.getHeight();
            }
        }

        Paint p = new Paint();
        canvas.drawBitmap(gre_rec,x,y,p);
        invalidate();
    }
    public void setPos(int a,int b){
        dx = a;
        dy = b;
    }
    public void setSize(String shape,String size){
        //Square shape
        if(shape.equals("square")){
            gre_rec = BitmapFactory.decodeResource(getResources(), R.mipmap.rect_green);

            //Small size
            if(size.equals("small")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) 70) / width;
                float scaleHeight = ((float) 70) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
            //Medium size square
            else if(size.equals("medium")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) 150) / width;
                float scaleHeight = ((float) 150) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
            //Large size square
            else if(size.equals("large")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) can.getWidth()) / width;
                float scaleHeight = ((float) can.getWidth()) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
        }
        //Rectangle shape
        else if(shape.equals("rect")){
            gre_rec = BitmapFactory.decodeResource(getResources(), R.mipmap.rect_green);
            //Small size rectangle
            if(size.equals("small")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) 140) / width;
                float scaleHeight = ((float) 70) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
            //Medium size rectangle
            else if(size.equals("medium")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) 300) / width;
                float scaleHeight = ((float) 150) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
            //large size rectangle
            else if(size.equals("large")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) can.getWidth()) / width;
                float scaleHeight = ((float) can.getWidth()/2) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
        }
        //Circle
        else if(shape.equals("circle")){
            gre_rec = BitmapFactory.decodeResource(getResources(),R.mipmap.circle_green);
            //Small size circle
            if(size.equals("small")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) 70) / width;
                float scaleHeight = ((float) 70) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
            //Medium size circle
            else if(size.equals("medium")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) 150) / width;
                float scaleHeight = ((float) 150) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
            //large size circle
            else if(size.equals("large")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) can.getWidth()) / width;
                float scaleHeight = ((float) can.getWidth()) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
        }

        //Oval coding
        else if(shape.equals("oval")){
            gre_rec = BitmapFactory.decodeResource(getResources(),R.mipmap.circle_green);
            //Small size oval
            if(size.equals("small")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) 140) / width;
                float scaleHeight = ((float) 70) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
            //Medium size oval
            else if(size.equals("medium")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) 300) / width;
                float scaleHeight = ((float) 150) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
            //Large size oval
            else if(size.equals("large")){
                int width = gre_rec.getWidth();
                int height = gre_rec.getHeight();
                float scaleWidth = ((float) can.getWidth()) / width;
                float scaleHeight = ((float) can.getWidth()/2) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap newB = Bitmap.createBitmap(gre_rec, 0, 0, width, height, matrix, false);
                gre_rec.recycle();
                gre_rec = newB;
            }
        }
        //Check overflow on shape change
        if(x+gre_rec.getWidth()>can.getWidth()){
            x=0;
        }
        if(y+gre_rec.getHeight()>can.getHeight()){
            y=0;
        }
    }
}
