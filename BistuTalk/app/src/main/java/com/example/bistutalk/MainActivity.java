package com.example.bistutalk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity {


    public static LinearLayout li1, li2, li3, li4;
    public static Button button, button2, button3, button4, button5;
    public ImageView imageView, imageView2, imageView3, imageView4,imageView5,imageView6,imageView7,imageView8;
    public static Map<String, View> map = new HashMap<>();
    String url1 = "";
    String url2 = "";
    String url3 = "";
    HttpURLConnection httpURLConnection;
    LinearLayout linearLayout,linearLayout2;

    String string = "http://webcal123.top/shen1.jpg";
    String string2 = "http://webcal123.top/shen2.jpg";
    String string3 = "http://webcal123.top/shen3.jpg";
    String string4 = "http://webcal123.top/shen4.jpg";
    String string5 = "http://webcal123.top/xue1.jpg";
    String string6 = "http://webcal123.top/xue2.jpg";
    String string7 = "http://webcal123.top/xue3.jpg";
    String string8 = "http://webcal123.top/shen.jpg";
    TextView textView2 ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(//必须要的线程对象管理策略
                new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build()
        );


        li4 = (LinearLayout) findViewById(R.id.Li4);
        li3 = (LinearLayout) findViewById(R.id.Li);
        li2 = (LinearLayout) findViewById(R.id.Li2);
        li1 = (LinearLayout) findViewById(R.id.Li3);

        textView2=(TextView)findViewById(R.id.text2);
        linearLayout=(LinearLayout)findViewById(R.id.Lin);
        linearLayout.setVisibility(View.GONE);
        linearLayout2=(LinearLayout)findViewById(R.id.Lin2);
        linearLayout2.setVisibility(View.GONE);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        Button lbutton = (Button)findViewById(R.id.load);
        imageView = (ImageView) findViewById(R.id.images);
        imageView2 = (ImageView) findViewById(R.id.images2);
        imageView3 = (ImageView) findViewById(R.id.images3);
        imageView4=(ImageView)findViewById(R.id.images4);
        imageView5=(ImageView)findViewById(R.id.images5);
        imageView6=(ImageView)findViewById(R.id.images6);
        imageView7=(ImageView)findViewById(R.id.images7);
        imageView8=(ImageView)findViewById(R.id.images8);




        button.setOnClickListener(new ClickView());
        button2.setOnClickListener(new ClickView());
        button3.setOnClickListener(new ClickView());
        button4.setOnClickListener(new ClickView());
        lbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView2.setVisibility(View.GONE);

                    loadView(string,0);
                    loadView(string2,1);
            //        loadView(string3,2);
//                    loadView(string4,3);
                    loadView(string5,4);
                    loadView(string6,5);
              //     loadView(string7,6);

                    linearLayout.setVisibility(View.VISIBLE);
                    linearLayout2.setVisibility(View.VISIBLE);
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });


        li1.setOnTouchListener(new MyTouch());
        li2.setOnTouchListener(new MyTouch());
        li3.setOnTouchListener(new MyTouch());
        li4.setOnTouchListener(new MyTouch());
        map.put("1", li1);
        map.put("2", li2);
        map.put("3", li3);
        map.put("4", li4);
    }



    public  void loadView(String string, int i){
        try {
            URL url = new URL(string);
             httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                MyHandler myHandler = new MyHandler();
                myHandler.obtainMessage(i, bitmap).sendToTarget();
                int result = inputStream.read();
                while (result != -1) {

                    result = inputStream.read();
                }
                //inputStream.close();
            }

        } catch (Exception e) {

        }
    }

    class  MyHandler extends Handler {

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0)

            imageView.setImageBitmap((Bitmap) msg.obj);
            if(msg.what==1)
                imageView2.setImageBitmap((Bitmap) msg.obj);
            if(msg.what==2)
                imageView3.setImageBitmap((Bitmap) msg.obj);
            if(msg.what==3)
                imageView4.setImageBitmap((Bitmap) msg.obj);
            if(msg.what==4)
                imageView5.setImageBitmap((Bitmap) msg.obj);
            if(msg.what==5)
                imageView6.setImageBitmap((Bitmap) msg.obj);
            if(msg.what==6)
                imageView7.setImageBitmap((Bitmap) msg.obj);
        }
    }

}

