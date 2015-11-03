package com.example.indiaroseapplicationdessin.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by lisa on 13/05/14.
 */
public class Resultat extends Activity implements View.OnClickListener {
    private ProgressBar mProgress;
    private Button menu;
    private Button reessayer;
    private TextView text;
    private Handler handler = new Handler();
    public static Modele m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        mProgress = (ProgressBar) findViewById(R.id.progress);
        text = (TextView) findViewById(R.id.res);

        mProgress.setClickable(false);
        new Thread(new Runnable() {
            public void run() {
                   handler.post(new Runnable() {
                        public void run() {
                           mProgress.setProgress(m.getmProgressStatus());
                            if(m.getmProgressStatus()==100){
                                text.setText(m.getmProgressStatus()+"% \n Félicitations !!");
                            } else if (m.getmProgressStatus() > 65){
                                text.setText(m.getmProgressStatus()+"% \n Tu y es presque");
                            } else {
                                text.setText(m.getmProgressStatus()+"%");
                            }
                        }
                    });
            }
        }).start();
        saveProgres();
        ajouterVues();
        ajouterListeners();
    }

    private void saveProgres() {
    }

    protected void ajouterVues(){
        menu = (Button) findViewById(R.id.menu);
        reessayer = (Button) findViewById(R.id.reessayer);
    }

    protected void ajouterListeners(){

        menu.setOnClickListener(this);
        reessayer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.menu :
                Intent i = new Intent(this, MenuActivity.class);
                MenuActivity.page= 0;
                startActivity(i);
                finish();
                break;
            case R.id.reessayer : Intent j = new Intent(this, GrilleActivity.class);
                startActivity(j);
                finish(); break;
        }

    }


}
