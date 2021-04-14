package com.hanseltritama.viewpager2horizontalvertical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vpVertical, vpHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpVertical = findViewById(R.id.vp_vertical);
        vpHorizontal = findViewById(R.id.vp_horizontal);
    }
}