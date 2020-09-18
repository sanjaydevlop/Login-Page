package com.test.op_boltay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    Button btn_2;
    Button btn_1;
    Button btn_3;
    Button btn_4;
    EditText etv;
    EditText etv2;
    int minteger=0;
    String _stringVal;
    DatabaseReference rootRef, Rd_1Ref,Rd_2Ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        // Database reference pointing to Rd_1 node
        Rd_1Ref = rootRef.child("Rd_1");
        Rd_2Ref = rootRef.child("Rd_2");

        etv = findViewById(R.id.etv_1);
        etv2 = findViewById(R.id.etv_2);
        btn_2 = findViewById(R.id.btn_2);
        btn_1 = findViewById(R.id.btn_1);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minteger = minteger + 1;
                _stringVal = String.valueOf(minteger);
                etv.setText(_stringVal);
            }
        });


        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minteger = minteger - 1;
                _stringVal = String.valueOf(minteger);
                etv.setText(_stringVal);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = etv.getText().toString();
                // Push creates a unique id in database
                Rd_1Ref.setValue(value);

                String value2 = etv2.getText().toString();
                // Push creates a unique id in database
                Rd_2Ref.setValue(value2);


            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Rd_1Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        etv.setText(value);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_LONG).show();
                    }
                });


                Rd_2Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String value2 = dataSnapshot.getValue(String.class);
                        etv2.setText(value2);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_LONG).show();
                    }
                });














            }
        });


    }
}
