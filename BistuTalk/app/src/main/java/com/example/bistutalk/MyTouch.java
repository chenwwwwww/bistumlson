package com.example.bistutalk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

class MyTouch implements View.OnTouchListener {
    int sx, mx, ex;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            sx = (int) event.getX();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            mx = (int) event.getX();
            v.setX(mx);
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            ex = (int) event.getX();

            //-----------------------------------------------------------------
            if ((ex - sx) > 50) {
                if (v == MainActivity.li1) {
                    v.setX(0);
                }
                if (v == MainActivity.li2) {
                    MainActivity.li2.setVisibility(View.GONE);
                    MainActivity.li3.setVisibility(View.GONE);
                    MainActivity.li4.setVisibility(View.GONE);
                    MainActivity.li1.setVisibility(View.VISIBLE);
                    MainActivity.li1.setX(0);
                }
                if (v == MainActivity.li3) {

                    MainActivity.li3.setVisibility(View.GONE);
                    MainActivity.li2.setVisibility(View.VISIBLE);
                    MainActivity.li2.setX(0);
                    MainActivity.li1.setVisibility(View.GONE);
                    MainActivity.li4.setVisibility(View.GONE);

                }
                if (v == MainActivity.li4) {
                    MainActivity.li4.setVisibility(View.GONE);
                    MainActivity.li3.setVisibility(View.VISIBLE);
                    MainActivity.li3.setX(0);
                    MainActivity.li1.setVisibility(View.GONE);
                    MainActivity.li2.setVisibility(View.GONE);

                }

            } else {
                v.setX(0);
            }
            //-----------------------------------------------------------------
            if ((sx - ex) > 50) {

                if (v == MainActivity.li4) {
                    v.setX(0);
                }
                if (v == MainActivity.li2) {
                    MainActivity.li2.setVisibility(View.GONE);
                    MainActivity.li3.setVisibility(View.VISIBLE);
                    MainActivity.li3.setX(0);
                    MainActivity.li1.setVisibility(View.GONE);
                    MainActivity.li4.setVisibility(View.GONE);

                }
                if (v == MainActivity.li1) {
                    MainActivity.li1.setVisibility(View.GONE);
                    MainActivity.li2.setVisibility(View.VISIBLE);
                    MainActivity.li2.setX(0);
                    MainActivity.li3.setVisibility(View.GONE);
                    MainActivity.li4.setVisibility(View.GONE);
                }
                if (v == MainActivity.li3) {
                    MainActivity.li3.setVisibility(View.GONE);
                    MainActivity.li4.setVisibility(View.VISIBLE);
                    MainActivity.li4.setX(0);
                    MainActivity.li2.setVisibility(View.GONE);
                    MainActivity.li1.setVisibility(View.GONE);
                }
                else {
                    v.setX(0);
                }
            }

        }
        return true;
    }
}
