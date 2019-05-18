package com.example.bistutalk;

import android.view.View;

import static com.example.bistutalk.MainActivity.*;

public class ClickView implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        if (v == MainActivity.button) {
            li1.setVisibility(View.VISIBLE);
            li3.setVisibility(View.GONE);
            li2.setVisibility(View.GONE);
            li4.setVisibility(View.GONE);
        }
        if (v == MainActivity.button2) {
            li2.setVisibility(View.VISIBLE);
            li1.setVisibility(View.GONE);
            li3.setVisibility(View.GONE);
            li4.setVisibility(View.GONE);
        }
        if (v == MainActivity.button3) {
            li3.setVisibility(View.VISIBLE);
            li1.setVisibility(View.GONE);
            li2.setVisibility(View.GONE);
            li4.setVisibility(View.GONE);
        }
        if (v == MainActivity.button4) {
            li4.setVisibility(View.VISIBLE);
            li1.setVisibility(View.GONE);
            li2.setVisibility(View.GONE);
            li3.setVisibility(View.GONE);
        }
    }
}
