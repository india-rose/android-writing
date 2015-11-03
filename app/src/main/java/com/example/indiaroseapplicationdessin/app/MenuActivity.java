package com.example.indiaroseapplicationdessin.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.io.File;
import java.util.ArrayList;


public class MenuActivity  extends ActionBarActivity implements View.OnClickListener{

    private ImageButton buttonm, boutonPlus, boutonNext;
    private ProgressBar pb;
    protected ArrayList<Integer> exercices = new ArrayList<Integer>();
    protected ExerciceList exosAjoutes = new ExerciceList();
    protected LinearLayout ex;
    protected LinearLayout menu;
    private static final int IMAGE_REQUEST = 1889;
    public static int page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lettre);
        loadExercices();
        ajouterVues();
    }

    //chargement des exercices
    private void loadExercices() {

        exercices.add(R.drawable.zero);
        exercices.add(R.drawable.un);
        exercices.add(R.drawable.deux);
        exercices.add(R.drawable.trois);
        exercices.add(R.drawable.quatre);
        exercices.add(R.drawable.cinq);
        exercices.add(R.drawable.six);
        exercices.add(R.drawable.sept);
        exercices.add(R.drawable.huit);
        exercices.add(R.drawable.neuf);
        exercices.add(R.drawable.amaj);
        exercices.add(R.drawable.bmaj);
        exercices.add(R.drawable.cmaj);
        exercices.add(R.drawable.dmaj);
        exercices.add(R.drawable.emaj);
        exercices.add(R.drawable.fmaj);
        exercices.add(R.drawable.gmaj);
        exercices.add(R.drawable.hmaj);
        exercices.add(R.drawable.imaj);
        exercices.add(R.drawable.jmaj);
        exercices.add(R.drawable.kmaj);
        exercices.add(R.drawable.lmaj);
        exercices.add(R.drawable.mmaj);
        exercices.add(R.drawable.nmaj);
        exercices.add(R.drawable.omaj);
        exercices.add(R.drawable.pmaj);
        exercices.add(R.drawable.qmaj);
        exercices.add(R.drawable.rmaj);
        exercices.add(R.drawable.smaj);
        exercices.add(R.drawable.tmaj);
        exercices.add(R.drawable.umaj);
        exercices.add(R.drawable.vmaj);
        exercices.add(R.drawable.wmaj);
        exercices.add(R.drawable.xmaj);
        exercices.add(R.drawable.ymaj);
        exercices.add(R.drawable.zmaj);
        exercices.add(R.drawable.a);
        exercices.add(R.drawable.b);
        exercices.add(R.drawable.c);
        exercices.add(R.drawable.d);
        exercices.add(R.drawable.e);
        exercices.add(R.drawable.f);
        exercices.add(R.drawable.g);
        exercices.add(R.drawable.h);
        exercices.add(R.drawable.i);
        exercices.add(R.drawable.j);
        exercices.add(R.drawable.k);
        exercices.add(R.drawable.l);
        exercices.add(R.drawable.m);
        exercices.add(R.drawable.n);
        exercices.add(R.drawable.o);
        exercices.add(R.drawable.p);
        exercices.add(R.drawable.q);
        exercices.add(R.drawable.r);
        exercices.add(R.drawable.s);
        exercices.add(R.drawable.t);
        exercices.add(R.drawable.u);
        exercices.add(R.drawable.v);
        exercices.add(R.drawable.w);
        exercices.add(R.drawable.x);
        exercices.add(R.drawable.y);
        exercices.add(R.drawable.z);
        Log.e("exercices","chargé");

        try {

           exosAjoutes= ExerciceXmlConverter.getInstance().read(Environment.getExternalStorageDirectory().getPath() + "/IndiaRose/ecriture/exercice.xml");
        } catch (Exception e) {
           Log.e("erreur",""+e);
           e.printStackTrace();
        }

    }


    // mise en place de la vue
    protected void ajouterVues(){
        int j =0;
        int x = getWindowManager().getDefaultDisplay().getWidth();
        int y = getWindowManager().getDefaultDisplay().getHeight();
        Log.e("width",""+x);
        Log.e("heigt",""+y);
        menu = (LinearLayout) this
                .getLayoutInflater().inflate(R.layout.lettre, null);
        menu.setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        menu.setOrientation(LinearLayout.HORIZONTAL);
        menu.setBackgroundColor(getResources().getColor(R.color.FondBleu));

        LinearLayout.LayoutParams parametre = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        parametre.weight=20f;

        LinearLayout exos = (LinearLayout) this
                .getLayoutInflater().inflate(R.layout.lettre, null);
        exos.setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        exos.setOrientation(LinearLayout.HORIZONTAL);
        exos.setLayoutParams(parametre);

        LinearLayout lignes = (LinearLayout) this
                .getLayoutInflater().inflate(R.layout.lettre, null);
        lignes.setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        lignes.setOrientation(LinearLayout.VERTICAL);

        LinearLayout ligne1 = (LinearLayout) this
                .getLayoutInflater().inflate(R.layout.lettre, null);
        ligne1.setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        ligne1.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout ligne2 = (LinearLayout) this
                .getLayoutInflater().inflate(R.layout.lettre, null);
        ligne2.setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        ligne2.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout ligne3 = (LinearLayout) this
                .getLayoutInflater().inflate(R.layout.lettre, null);
        ligne3.setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        ligne3.setOrientation(LinearLayout.HORIZONTAL);

        for (int i=page*15; i<Math.min(page*15 + 15, exercices.size() + exosAjoutes.size()); i++){
            ex = (LinearLayout) this
                    .getLayoutInflater().inflate(R.layout.lettre, null);
            ex.setLayoutParams(new ViewGroup.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            ex.setOrientation(LinearLayout.VERTICAL);
            buttonm= new ImageButton(getApplicationContext());
            if (i-page*15<exercices.size()){
            buttonm.setImageDrawable(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), exercices.get(i)), x/5 , Math.min(x,y)/3 -(Math.min(x,y)*2/20), false)));
            }else {
            buttonm.setImageDrawable(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeFile(exosAjoutes.get(i-exercices.size()).getImage()), x/5 , Math.min(x,y)/3 -(Math.min(x,y)*2/20), false)));
            }
             buttonm.setId(i);
            ex.addView(buttonm, x*80/100/5, Math.min(x,y)/3-(Math.min(x,y)*2/20));
            pb= new ProgressBar(getApplicationContext());
            pb.setIndeterminate(false);
            ex.addView(pb, x*80/100/5, y/20);
            buttonm.setOnClickListener(this);
            pb.setOnClickListener(this);
            if (j<5){
                ligne1.addView(ex);
            } else if (j<10){
                ligne2.addView(ex);
            }else if (j<15){
                ligne3.addView(ex);
           }
            j++;
        }
        if (exercices.size() + exosAjoutes.size()<(page+1)*15){
            page=-1;
        }
        lignes.addView(ligne1);
        lignes.addView(ligne2);
        lignes.addView(ligne3);
        exos.addView(lignes);

        LinearLayout param = (LinearLayout) this
                .getLayoutInflater().inflate(R.layout.lettre, null);
        param.setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        param.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        params.weight=80f;
        param.setLayoutParams(params);

        LinearLayout option = (LinearLayout) this
                .getLayoutInflater().inflate(R.layout.lettre, null);
        option.setLayoutParams(new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        option.setOrientation(LinearLayout.VERTICAL);

        boutonPlus = new ImageButton (getApplicationContext());
        boutonPlus.setImageDrawable(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plus), x/5 , y/3, false)));
        boutonPlus.setId(exercices.size()+exosAjoutes.size() + 1);
        boutonPlus.setOnClickListener(this);
        option.addView(boutonPlus);
        boutonNext = new ImageButton (getApplicationContext());
        boutonNext.setImageDrawable(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.next), x/5 , y/3, false)));
        boutonNext.setId(exercices.size()+exosAjoutes.size() + 2);
        boutonNext.setOnClickListener(this);
        option.addView(boutonNext);
        param.addView(option);
        menu.addView(exos);
        menu.addView(param);
        setContentView(menu);
    }

    public void onClick (View v) {
        Log.e("on","click "+v);
        if (v.getId()== exercices.size()+exosAjoutes.size()+1){
            ajoutExercice();
        }else {
            if (v.getId()== exercices.size()+exosAjoutes.size()+2){
                Log.e("page suivante", ""+page++);
                Intent i = new Intent(this, MenuActivity.class);
                MenuActivity.page= page++;
                startActivity(i);
                finish();
            }else {
            if (v.getId()<exercices.size()){
          Intent i = new Intent(this, GrilleActivity.class);
          GrilleActivity.model= new Modele ("test", BitmapFactory.decodeResource(getResources(), exercices.get(v.getId())));
          GrilleActivity.rajout=0;
          startActivity(i);
          finish();
            } else {
                Intent i = new Intent(this, GrilleActivity.class);
                GrilleActivity.model= new Modele ("test", BitmapFactory.decodeFile(exosAjoutes.get(v.getId()-exercices.size()).getImage()));
                GrilleActivity.rajout=0;
                startActivity(i);
                finish();
            }
        }
        }

    }


    //ajouter un exercice
    protected void ajoutExercice() {
        final Dialog ExDialog = new Dialog(this);
        ExDialog.setTitle("Choisissez l'exercice à ajouter");
        ExDialog.setContentView(R.layout.choix_exercice);

        Button gallerie = (Button)ExDialog.findViewById(R.id.gallerie);
        gallerie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,IMAGE_REQUEST);
                ExDialog.dismiss();
            }
        });
        Button dessinerEx = (Button)ExDialog.findViewById(R.id.dessiner);
       dessinerEx.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               dessinerExercice();
                ExDialog.dismiss();
            }
        });
        Button cancel = (Button)ExDialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExDialog.dismiss();
            }
        });

        ExDialog.show();
    }

    //dessiner un nouvel exercice
    private void dessinerExercice() {
        Intent i = new Intent(this, GrilleActivity.class);
        GrilleActivity.model= new Modele ("test", BitmapFactory.decodeResource(getResources(), R.drawable.blanc));
        GrilleActivity.rajout=exosAjoutes.size()+1;
        startActivityForResult(i, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("test", ""+requestCode);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case IMAGE_REQUEST:
                    Uri selectImage = data.getData();

                    if (selectImage != null) {
                        String filePath;
                        String imageID = data.getDataString();
                        Log.e("image",""+imageID);
                        Uri MyUri = Uri.parse(imageID);
                        String[] proj = {MediaStore.Images.Media.DATA};
                        Cursor tempCursor = managedQuery(MyUri,proj, null, null, null);
                        tempCursor.moveToFirst(); //reset the cursor
                        do{
                            int column_index = tempCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                            filePath = tempCursor.getString(column_index);
                        }while(tempCursor.moveToNext());
                           Log.e("file path", ""+filePath.toString());
                        SaveExercice(filePath.toString());
                        Intent i = new Intent(this, MenuActivity.class);
                        startActivity(i);
                        finish();
                    }
                    break;
                case 1 :
                    SaveExercice(data.getExtras().getString("exercice"));
                    Intent in = new Intent(this, MenuActivity.class);
                    startActivity(in);
                    finish();
                    break;
                default :   Intent inte = new Intent(this, MenuActivity.class);
                    startActivity(inte);
                    finish();
                    break;
            }

        }
    }

    //sauvegarde d'un exercice : inscription sur le fichier xml
    private void SaveExercice(String s) {
        File direction = new File(Environment.getExternalStorageDirectory().getPath() + "/IndiaRose");
        File dir = new File(Environment.getExternalStorageDirectory().getPath() + "/IndiaRose/ecriture");
        if(!direction.exists())
        {
            Log.e("Ecriture", "Create directory " + dir.getPath());
            if(direction.mkdir())
            {
                Log.e("Ecriture", "Created !");
            }
            else
            {
                Log.e("Ecriture", "ERROR !!!!");
            }
        }
        else
        {
            Log.e("Ecriture", "Directory " + dir.getPath() + " already exists");
        }

        if(!dir.exists())
        {
            Log.e("Ecriture", "Create directory " + dir.getPath());
            if(dir.mkdir())
            {
                Log.e("Ecriture", "Created !");
            }
            else
            {
                Log.e("Ecriture", "ERROR !!!!");
            }
        }
        else
        {
            Log.e("Ecriture", "Directory " + dir.getPath() + " already exists");
        }
        try {
        //    ExerciceList save = ExerciceXmlConverter.getInstance().read(Environment.getExternalStorageDirectory().getPath() + "/IndiaRose/ecriture/exercice.xml");
         //   save.ajouter(new Exercice(s));
            ExerciceXmlConverter.getInstance().write(new ExerciceList(new Exercice(s))/*save*/, Environment.getExternalStorageDirectory().getPath() + "/IndiaRose/ecriture/exercice.xml");
            Log.e("exercice"+s,"sauvegardé !");
        } catch (Exception e) {
            Log.e("erreur","erreur lors de la sauvegarde");
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
