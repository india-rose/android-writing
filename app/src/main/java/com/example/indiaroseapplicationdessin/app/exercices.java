package com.example.indiaroseapplicationdessin.app;

/**
 * Created by lisa on 27/05/14.
 */
public class exercices {
    private String image;
    private int progres;

    public exercices(String image) {
        this.image = image;
        progres=0;
    }

    public exercices(String image, int progres) {
        this.image = image;
        this.progres = progres;
    }

    public int getProgres() {
        return progres;
    }

    public void setProgres(int progres) {
        this.progres = progres;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
