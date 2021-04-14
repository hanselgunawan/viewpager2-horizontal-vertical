package com.hanseltritama.viewpager2horizontalvertical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vpVertical, vpHorizontal;
    int[] images = {
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six,
        R.drawable.seven,
        R.drawable.eight
    };

    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpVertical = findViewById(R.id.vp_vertical);
        vpHorizontal = findViewById(R.id.vp_horizontal);

        // Initialize main adapter
        adapter = new MainAdapter(images);

        // Set adapter on Vertical ViewPager
        vpVertical.setAdapter(adapter);

        // Set clip padding
        vpHorizontal.setClipToPadding(false);
        // Set clip children
        vpHorizontal.setClipChildren(false);
        // Set page limit
        vpHorizontal.setOffscreenPageLimit(3);
        // Set default start position
        vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        // Set adapter on horizontal viewpager
        vpHorizontal.setAdapter(adapter);

        CompositePageTransformer transformer = new CompositePageTransformer();
        // Add margin between page
        transformer.addTransformer(new MarginPageTransformer(8));
        // Increase selected page size
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float v = 1 - Math.abs(position);
                // Set scale y
                page.setScaleY(0.8f + v * 0.2f);
            }
        });

        // Set page transform
        vpHorizontal.setPageTransformer(transformer);
    }
}