package fr.amu.iut.exercice13;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.List;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static ListChangeListener<Personne> unChangementListener;
    private static ListChangeListener<Personne> plusieursChangementsListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList(personne -> new Observable[] {personne.ageProperty()});

        plusieursChangementsListener = change -> {
            change.next();
            if(change.wasAdded()) {
                for(int i = 0; i < change.getAddedSize(); ++i) {
                    Personne leChange = change.getAddedSubList().get(i);
                    System.out.println(leChange.getNom());
                }
            }
            if(change.wasRemoved()) {
                for(int i = 0; i < change.getRemovedSize(); ++i) {
                    Personne leChange = change.getRemoved().get(i);
                    System.out.println(leChange.getNom());
                }
            }
            if(change.wasUpdated()) {
                int debut = change.getFrom();
                int fin = change.getTo();
                for (int i = debut; i < fin; ++i){
                    Personne leChange = change.getList().get(i);
                    System.out.println(leChange.getNom() + " a maintenant " + leChange.getAge() + " ans");
                }
            }
        };

        unChangementListener = change -> {
            change.next();
            if(change.wasAdded()) System.out.println(change.getAddedSubList().get(0).getNom());
            if(change.wasRemoved()) System.out.println(change.getRemoved().get(0).getNom());
            if(change.wasUpdated()) {
                Personne leChange = change.getList().get(change.getFrom());
                System.out.println(leChange.getNom() + " a maintenant " + leChange.getAge() + " ans");
            }
        };

        lesPersonnes.addListener(plusieursChangementsListener);

        question5();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}