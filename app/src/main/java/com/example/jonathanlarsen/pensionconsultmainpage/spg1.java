package com.example.jonathanlarsen.pensionconsultmainpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

public class spg1 extends AppCompatActivity implements View.OnClickListener {
    RadioButton svar1, svar2, svar3, svar4;
    Button tilbage, naeste, annuller;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spg);

        svar1 = (RadioButton) findViewById(R.id.radioButton);
        svar2 = (RadioButton) findViewById(R.id.radioButton2);
        svar3 = (RadioButton) findViewById(R.id.radioButton3);
        svar4 = (RadioButton) findViewById(R.id.radioButton4);

        tilbage = (Button) findViewById(R.id.backBut);
        naeste = (Button) findViewById(R.id.nextBut);
        annuller = (Button) findViewById(R.id.anullBut);



        svar1.setOnClickListener(this);
        svar2.setOnClickListener(this);
        svar3.setOnClickListener(this);
        svar4.setOnClickListener(this);
        tilbage.setOnClickListener(this);
        naeste.setOnClickListener(this);
        annuller.setOnClickListener(this);

        TextView tv = (TextView) findViewById(R.id.question);
        tv.setText("Hvor vigtig tror du din pensionsopsparing bliver for din samlede økonomi, når du går på pension?");
        svar1.setText("Ingen betydning");
        svar2.setText("Nogen betydning");
        svar3.setText("Forholdsvis stor betydning");
        svar4.setText("Meget stor betydning");

        bar = (ProgressBar) findViewById(R.id.progressBar);
        bar.setMax(4);
        bar.setProgress(1);
    }

    @Override
    public void onClick(View view) {
        if (view==naeste) {
            Intent i = new Intent(this, spg2.class);
            startActivity(i);
        }
        else if (view==tilbage) {
            //Intent i = new Intent(this, HOME); //indsæt samme som annuller
            //startActivity(i);
        }
        else if (view==annuller){
            Intent i = new Intent(this, FrontPage.class);
            startActivity(i);
        }
    }
}
