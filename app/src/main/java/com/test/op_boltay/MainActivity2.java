package com.test.op_boltay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {
    Button login_btn;
    ImageView img_1;

    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        login_btn = findViewById(R.id.login_btn);
        img_1 = findViewById(R.id.img_1);
        context = getApplicationContext();
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        Glide.with(MainActivity2.context).load("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimage.freepik.com%2Ffree-icon%2Fgithub-logo-in-a-rounded-square_318-40761.jpg&f=1&nofb=1").into(img_1);

    }
}