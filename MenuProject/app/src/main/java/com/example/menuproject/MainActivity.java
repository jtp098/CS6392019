package com.example.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button activity = findViewById(R.id.btnNewActivity);
        activity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NewActivity.class);
                startActivity(i);
                finish();

            }
        });

        Button sms = findViewById(R.id.btnSms);
        sms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + Uri.encode("2038758978")));
                intent.putExtra("sms_body", "John Pelliccia");
                startActivity(intent);

            }
        });

        Button call = findViewById(R.id.btnPhone);
        call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "2038758978"));
                startActivity(intent);

            }
        });

        Button web = findViewById(R.id.btnWeb);
        web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.macrumors.com"));
                startActivity(intent);

            }
        });

        Button maps = findViewById(R.id.btnMap);
        maps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String geoUri = String.format("geo:42.342824, -71.079408");
                Uri geo = Uri.parse(geoUri);
                final Intent intent = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(intent);

            }
        });

        Button share = findViewById(R.id.btnShare);
        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Share the love"));
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
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_help:
                Intent help = new Intent(this, HelpActivity.class);
                startActivity(help);
                return true;
            case R.id.action_settings:
                //showHelp();
                return true;
            default:

        }

        return super.onOptionsItemSelected(item);

    }


}
