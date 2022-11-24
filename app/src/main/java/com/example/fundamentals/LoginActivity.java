package com.example.fundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class LoginActivity extends AppCompatActivity {

    private ImageView innet;
    private ImageView logito;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        innet = findViewById(R.id.girl);
        logito = findViewById(R.id.tree);

        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logear();
            }
        });

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        logito.startAnimation(myanim);

        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotation);
        innet.startAnimation(rotate);

        //String imagen = "https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80";
        //Glide.with(getApplicationContext()).load(imagen).into(innet);


        Glide.with(this)
//              .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
                .load(R.drawable.universo)
//                .transition(DrawableTransitionOptions.withCrossFade(1000))
//                .placeholder(R.drawable.gradient)
                .centerCrop()
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.fucsia_200)))
//                .circleCrop()
                .into(innet);

        Glide.with(this)
//              .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
                .load(R.drawable.astronauta)
//                .centerCrop()
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.fucsia_200)))
                .circleCrop()
                .into(logito);
    }

    // Method for Signup text
    public void openSignup(View v) {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void logear() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}