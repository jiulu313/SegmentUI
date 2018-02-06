package com.jiulu.segment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
    FrameLayout flContainer;
    Button btnTest;
    Button btnChange;
    Button btnRemove;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flContainer = findViewById(R.id.fl_container);
        btnTest = findViewById(R.id.btn_test);
        btnChange = findViewById(R.id.btn_change);
        btnRemove = findViewById(R.id.btn_remove);


        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChange();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRemove();
            }
        });
    }


    ViewGroup parent = null;

    //删除
    private void onRemove() {
        parent = (ViewGroup) btnTest.getParent();
        if(parent != null){
            parent.removeView(btnTest);
        }
    }

    private void onChange() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(400,200);
        Button button = new Button(this);
        button.setText("你好");
        button.setLayoutParams(layoutParams);



        View view = LayoutInflater.from(this).inflate(R.layout.title_bar,null);
        parent.addView(button);


    }
}
