package com.fitness.imageserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.cloudinary.android.MediaManager;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ImageView img1,img2,img3,img4,img5,img6;
    private VideoView video1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1=(ImageView)findViewById(R.id.img1);
        img2=(ImageView)findViewById(R.id.img2);
        img3=(ImageView)findViewById(R.id.img3);
        img4=(ImageView)findViewById(R.id.img4);
        img5=(ImageView)findViewById(R.id.img5);
        img6=(ImageView)findViewById(R.id.img6);

        video1 = (VideoView)findViewById(R.id.video1);

        try {
            Map config = new HashMap();
            config.put("cloud_name","emfitnessabs");
            MediaManager.init(this,config);

        }catch (Exception e){
            e.printStackTrace();
        }

        Glide.with(MainActivity.this)
                .load("https://res.cloudinary.com/emfitnessabs/image/upload/v1611350925/sample.jpg")
                .into(img1);

        Glide.with(MainActivity.this)
                .load("https://res.cloudinary.com/emfitnessabs/image/upload/v1611895280/emfitnessabs/almuerzo_s1rs4a.jpg").into(img2);

        Glide.with(MainActivity.this)
                .load("https://res.cloudinary.com/emfitnessabs/image/upload/v1611350931/samples/food/pot-mussels.jpg").into(img3);

        Glide.with(MainActivity.this)
                .load("https://res.cloudinary.com/emfitnessabs/image/upload/v1611350930/samples/food/fish-vegetables.jpg").into(img4);

        Glide.with(MainActivity.this)
                .load("https://res.cloudinary.com/emfitnessabs/image/upload/v1611350929/samples/food/dessert.jpg").into(img5);

        Glide.with(MainActivity.this)
                .load("https://res.cloudinary.com/emfitnessabs/image/upload/v1611350940/samples/animals/kitten-playing.gif")
                .into(img6);

        video1.setVideoPath("https://res.cloudinary.com/emfitnessabs/video/upload/v1611350944/samples/sea-turtle.mp4");
        video1.start();

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video1);
        video1.setMediaController(mediaController);
        //hola


    }
}