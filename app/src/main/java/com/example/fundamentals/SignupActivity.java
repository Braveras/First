package com.example.fundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SignupActivity extends AppCompatActivity {

    EditText edituser, editpassword, editpassword2, editemail;
    Button cancel;
    ImageView mFondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        cancel = findViewById(R.id.cancel);
        edituser = findViewById(R.id.edituser);
        editpassword = findViewById(R.id.editpassword);
        editemail = findViewById(R.id.editemail);
        editpassword2 = findViewById(R.id.editpassword2);
        mFondo = findViewById(R.id.fondo);

        Glide.with(this)
                .load("https://cdn.discordapp.com/attachments/771931863102652417/1046875852127862834/unknown.png")
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
                .into(mFondo);

        Animation slide_down = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        edituser.startAnimation(slide_down);
        editemail.startAnimation(slide_down);
        editpassword.startAnimation(slide_down);
        editpassword.startAnimation(slide_down);
        editpassword2.startAnimation(slide_down);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edituser.setText("");
                editpassword.setText("");
                editpassword2.setText("");
                editemail.setText("");

            }
        });

    }
}