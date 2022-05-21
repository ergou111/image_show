package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.spline.MyView;


public class SplineActivity extends Activity {
    private MyView canvasView;
    private Button btnClearPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spline);

        getViews();
        btnClearPoints.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                canvasView.clearPoints();
            }
        });
    }

    private void getViews() {
        canvasView = (MyView) findViewById(R.id.canvasView);
        btnClearPoints = (Button) findViewById(R.id.btnClearPoints);
    }
}