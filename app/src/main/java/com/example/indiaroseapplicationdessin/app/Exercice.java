package com.example.indiaroseapplicationdessin.app;

public class Exercice
{
	public String image;
    public int progress;

    public Exercice(String image, int progress) {
        this.image = image;
        this.progress = progress;
    }
    public Exercice(String image) {
        this.image = image;
        this.progress = 0;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}