package com.flames.flames;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private TextView mDisplayflames,name1,name2;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mDisplayflames=(TextView)findViewById(R.id.ans);
        name1=(TextView)findViewById(R.id.text1) ;
        name2=(TextView)findViewById(R.id.text2);
        Intent intentstartactivity=getIntent();
        final String n1=intentstartactivity.getStringExtra("n1");
        final String n2=intentstartactivity.getStringExtra("n2");
        final String res=intentstartactivity.getStringExtra("res");
        mDisplayflames.setText(res);
        name1.setText(n1);
        name2.setText(n2);
        Button bt=(Button)findViewById(R.id.share);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Flames between  " + n1 +"  and  "+ n2 +"  willbe   "+res;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }

    });

    }
}
