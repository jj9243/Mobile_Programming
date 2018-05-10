package com.example.imseokbin.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TouchEventView vw = new TouchEventView(this);
        setContentView(vw);
    }
    protected class TouchEventView extends View {

        Paint pnt = new Paint(); // path to draw line on the activity
        Path path = new Path(); // paint object to draw blue
        private int x; // x coordinate
        private int y; // y coordinate
        public TouchEventView(Context context){
            super(context);
            pnt.setStyle(Paint.Style.STROKE); // paint style
            pnt.setStrokeWidth(10f); // paint stroke width
        }
        protected void onDraw(Canvas canvas) {
            pnt.setColor(Color.BLUE); // set color to blue
            canvas.drawPath(path, pnt); // canvas to draw line on the activity ( by path)

        }
        public boolean onTouchEvent(MotionEvent event){ // method to handle touch event on the screen
            x = (int) event.getX(); // get x coordinate
            y = (int) event.getY(); // get y coordinate
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                path.moveTo(x,y); // if user touches the screen
            }
            if(event.getAction()==MotionEvent.ACTION_MOVE){
                path.lineTo(x,y); // if user moves finger to other screen
            }
            if(event.getAction() ==MotionEvent.ACTION_UP)
                return false;
            invalidate();

            return true;
        }



    }
}
