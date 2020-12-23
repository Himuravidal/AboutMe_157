package com.example.aboutme_157;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aboutme_157.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {

    private ActivityContactBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.imageViewLinkeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linkedingIntent = new Intent(Intent.ACTION_VIEW);
                linkedingIntent
                        .setData(Uri.parse("https://www.linkedin.com/in/cristianvidallopez/"));
                startActivity(linkedingIntent);

                Toast.makeText(ContactActivity.this, "Si pasa", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        mBinding.imageViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareWithWsp("Hola esto va para el whassapp");
            }
        });


    }

    public void shareWithWsp(String message){
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");
       // sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }


}