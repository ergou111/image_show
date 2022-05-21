package com.example.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class imageActivity extends Activity implements OnSeekBarChangeListener {
    private int minWidth = 80;
    private ImageView image;
    private TextView text;
    private TextView text2;
    private Matrix matrix = new Matrix();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        image = (ImageView) findViewById(R.id.image);
        SeekBar seekBar1 = (SeekBar) this.findViewById(R.id.seekbar);
        SeekBar seekBar2 = (SeekBar) this.findViewById(R.id.seekbar2);
        text = (TextView) this.findViewById(R.id.text);
        text2 = (TextView) this.findViewById(R.id.text2);
        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        seekBar1.setMax(dm.widthPixels - minWidth);



    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
// TODO Auto-generated method stub
        if (seekBar.getId() == R.id.seekbar) {
            int newWidth = progress + minWidth;
            int newHeight = (int) (newWidth * 3 / 4);
            image.setLayoutParams(new LinearLayout.LayoutParams(newWidth,
                    newHeight));
            text.setText("mage height: " + newWidth + "image width" + newHeight);
        } else if (seekBar.getId() == R.id.seekbar2) {
            Bitmap bitmap = ((BitmapDrawable) (getResources()
                    .getDrawable(R.drawable.aaaaa))).getBitmap();
            matrix.setRotate(progress);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                    bitmap.getHeight(), matrix, true);
            image.setImageBitmap(bitmap);
            text2.setText(progress + "degree");
        }
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub


    }


    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub


    }
}