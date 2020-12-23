package com.example.aboutme_157;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        //TODO inicializar viewBinding y aplicarlo
        ImageView imageView = findViewById(R.id.imageViewMain);
        Glide.with(this)
                .load("https://lh3.googleusercontent.com/3oR75ba4xCtdCbSDyxBbTRYtwptE9pPksLDcc2HLHGYWY2P-nM1MOQe4NhuOpwSqWdNWeuE_JzyIdwAh6UXd8mdZQTLVFUt5E6r12q6x_cp9Y8FeX37iRmtJhUac6-Yqj3VHEsC4jGJ30I87plkX1ZNmqvArkjr9SJKz6ju7RfeVgRS1tkCgiEl7lc3qivf5ZoHEa26p_wTP6PvVk08Iuj9GQoqtjBTnAKQKpFK4_HPDStzb3YAgoRRR55ElmR-RUflfFp7haVXJe3kDPeFPuelqOh_Hu1vy8IdNmPc0YWKV7QxmgNbpz-N9zIJNEkjrGxnnOMsfpS5oXjq2FRAXMp2-p1J_ewBsZog_FKwye_WTj9ObGdnALPKykpqm4DlAJhCtkcrU2PkavYphAEYSk7KXFGXI1DSo3wKtxke12jT34wUG9LPhsaLZkHoo5Qke8ohCVIEPpHwtKiJf0GmzXHfjgxQXbrH90o3wY3HgJ1MepoX7beHE5MM2nhR4QRreSMn4_m_mz4deZ9MRbZv3BsmesqcLs_uCiVO0XzTLVE7qY44XbePHaBHW8FeZNWjuP16eg3gDtHWb0UuggleOKe9IeNK_IMdCCINzZgM_mtJkzq04dShWeNw2ZZ594MFTEhBzumvjEb1Wh60zZvyqMl2ktresYz-KGvQJjAEqw2JUq5UnBRo5HUT3duEcjA=w755-h1006-no?authuser=0")
                .centerCrop()
                .into(imageView);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(mIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}