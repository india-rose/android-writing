package com.example.indiaroseapplicationdessin.app;

/**
 * Created by lisa on 29/04/14.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class GrilleActivity extends Activity implements View.OnClickListener {

    private Button valider;
    private FondDessin d;
    private LinearLayout exercice;
    public static Modele model;
    public static int rajout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      exercice = (LinearLayout) this
                .getLayoutInflater().inflate(R.layout.activity_grille, null);
        exercice.setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        exercice.setOrientation(LinearLayout.VERTICAL);

        d = new com.example.indiaroseapplicationdessin.app.FondDessin (getApplicationContext(), model.getModeleBitmap());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight=20f;
        d.setLayoutParams(params);

       valider = new Button(getApplicationContext());
        valider.setBackgroundColor(getResources().getColor(R.color.Rose));
        valider.setTextSize(50);
        valider.setText("Valider");
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        param.weight=80f;
       valider.setLayoutParams(param);

        exercice.addView(d);
        exercice.addView(valider);
           setContentView(exercice);

        ajouterListeners();
    }


    protected void ajouterListeners(){

        valider.setOnClickListener(this);
    }

   @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    @Override
    public void onClick(View view) {
        if (rajout !=0){
            File direction = new File(Environment.getExternalStorageDirectory().getPath() + "/IndiaRose");
            File dir = new File(Environment.getExternalStorageDirectory().getPath() + "/IndiaRose/Images");
            if(!direction.exists())
            {
                Log.e("Image", "Create directory " + dir.getPath());
                if(direction.mkdir())
                {
                    Log.e("Dossier", "Created !");
                }
                else
                {
                    Log.e("Dossier", "ERROR !!!!");
                }
            }
            else
            {
                Log.e("Image", "Directory " + dir.getPath() + " already exists");
            }

            if(!dir.exists())
            {
                Log.e("Image", "Create directory " + dir.getPath());
                if(dir.mkdir())
                {
                    Log.e("Image", "Created !");
                }
                else
                {
                    Log.e("Image", "ERROR !!!!");
                }
            }
            else
            {
                Log.e("Image", "Directory " + dir.getPath() + " already exists");
            }
            d.setDrawingCacheEnabled(true);
            try {
                d.getDrawingCache().compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(dir+"/Exercice-"+rajout+".jpg"));
                Log.e("dessin sauvegardé","nouvel exerice enregistré");
            } catch (FileNotFoundException e) {
                Log.e("erreur", "image non sauvegardé");
                e.printStackTrace();
            }
            Intent data = new Intent();
            data.putExtra("exercice",dir+"/Exercice-"+rajout+".jpg");
            setResult(RESULT_OK, data);
            super.finish();
            d.destroyDrawingCache();

        }else{
            model.setmProgressStatus(progression());
            Intent intent=new Intent(this, Resultat.class);
            Resultat.m=model;
            startActivity(intent);
            finish();
        }
    }


   //donne la progression
    public int progression (){
          d.setBackground(new BitmapDrawable(getResources(),BitmapFactory.decodeResource(getResources(), R.drawable.blanc)));
          d.setDrawingCacheEnabled(true);
            d.buildDrawingCache(true);
        Bitmap currentPaint = d.getDrawingCache();
        d.background();
            return ressemblance (model.getModeleBitmap(), currentPaint);
    }

    //calcul la ressemblance entre le modèle et le dessin pour la progression
    public int ressemblance(Bitmap bitmap1, Bitmap bitmap2) {
       bitmap1 = Bitmap.createScaledBitmap(bitmap1, d.getDrawCanvas().getWidth(), d.getDrawCanvas().getHeight()*80/100, false);
       ByteBuffer buffer1 = ByteBuffer.allocate(bitmap1.getHeight() * bitmap1.getRowBytes());
        bitmap1.copyPixelsToBuffer(buffer1);

        ByteBuffer buffer2 = ByteBuffer.allocate(bitmap2.getHeight() * bitmap2.getRowBytes());
        bitmap2.copyPixelsToBuffer(buffer2);
        int ressemblance=0;
        if (Arrays.equals(buffer1.array(), buffer2.array())){
            return 100;
        } else {
            for (int i=0; i<buffer1.array().length-1; i++){
              if((buffer1.array()[i]!=-1 && buffer2.array()[i]!=-1)
                    ||(i!=0 && buffer1.array()[i-1]!=-1 && buffer2.array()[i]!=-1)
                        || (i<buffer1.array().length-2 && buffer1.array()[i+1]!=-1 && buffer2.array()[i]!=-1)){
                    ressemblance=ressemblance+60;
                }
                if(buffer1.array()[i]==-1 && buffer2.array()[i]!=-1){
                    ressemblance=ressemblance-10;
                }
            }
            if (ressemblance*100/(buffer1.array().length+1)<0){
                return 0;
            }
            if (ressemblance*100/(buffer1.array().length+1)>85){
                return 100;
            }
            return (ressemblance*100/(buffer1.array().length+1));
        }
   }

}
