package com.example.indiaroseapplicationdessin.app;

import android.graphics.Bitmap;
import java.io.Serializable;

/**
 * Created by lisa on 13/05/14.
 */
public class Modele implements Serializable {
    private String name;
    private Bitmap modeleBitmap ;
    private int mProgressStatus = 0;


    public Modele (String s, Bitmap b){
        name=s;
        modeleBitmap=b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Bitmap getModeleBitmap() {
        return modeleBitmap;
    }

    public void setModeleBitmap(Bitmap modeleBitmap) {
        this.modeleBitmap = modeleBitmap;
    }

    public int getmProgressStatus() {
        return mProgressStatus;
    }

    public void setmProgressStatus(int mProgressStatus) {
        this.mProgressStatus = mProgressStatus;
    }

}
