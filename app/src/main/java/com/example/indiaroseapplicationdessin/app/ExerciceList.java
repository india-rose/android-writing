package com.example.indiaroseapplicationdessin.app;

import java.util.ArrayList;

public class ExerciceList
{
	public ArrayList<Exercice> exercices = new ArrayList<Exercice>();

    public ExerciceList(ArrayList<Exercice> exercices) {
        this.exercices = exercices;
    }

    public ExerciceList(Exercice exercices) {
        this.exercices.add(exercices);
    }
    public ExerciceList() {
        this.exercices = new ArrayList<Exercice>();
    }

    public ArrayList<Exercice> getExercices() {
        return exercices;
    }

    public Exercice get(int i) {
        return exercices.get(i);
    }

    public void setExercices(ArrayList<Exercice> exercices) {
        this.exercices = exercices;
    }

    public void ajouter (Exercice ex){
        exercices.add(ex);
    }

    public int size () {
        return exercices.size();
    }
}