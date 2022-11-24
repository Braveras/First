package com.example.fundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp();

        //implements and starts animation
        // objeto thunder sobre el cual aplicaremos la animación
        ImageView logo = findViewById(R.id.logoSplash);

        //creamos un objeto animación que incorpora la animación descrita en el xml y con el método
        // startAnimation lo aplicamos al imageview del logo
        Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        Animation fadeout = AnimationUtils.loadAnimation(this, R.anim.fadeout);

        //AnimationSet para cargar y usar varias animaciones
        AnimationSet s = new AnimationSet(false);//false means don't share interpolators
        s.addAnimation(zoomin);
        s.addAnimation(fadeout);
        logo.startAnimation(s);

        // Cargar fondo
        ImageView fondo = findViewById(R.id.splashBg);

        Glide.with(this)
                .load("https://w0.peakpx.com/wallpaper/918/398/HD-wallpaper-red-splosh-bertil-bright-full-fun-funny-mistake-oops-organic-paint-screen-shape-splash-water-thumbnail.jpg")
//                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
//                .circleCrop()
                .into(fondo);

    }

    private void openApp() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(Splash
                        .this, LoginActivity.class);
                startActivity(intent);
            }
        }, 1500);


    }

}