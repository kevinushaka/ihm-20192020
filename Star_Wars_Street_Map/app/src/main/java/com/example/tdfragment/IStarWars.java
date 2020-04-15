package com.example.tdfragment;

import java.util.ArrayList;
import java.util.List;

public interface IStarWars {

    public Character[] CHARACTERS=new Character[]{
            new Character("Luke Skywalker",
                    "Il est le fils d'Anakin Skywalker et de Padmé Amidala et le frère " +
                            "jumeau de la princesse Leia Organa.",
                    R.drawable.lukeskywalker),
            new Character("Kylo Ren",
                    "Fils de Leia Organa et de Han Solo, Ben a initialement reçu la " +
                            "formation de Luke Skywalker pour devenir un Jedi. Toutefois, il est " +
                            "passé du côté obscur de la Force, et s'est mis au service du Premier " +
                            "Ordre et de son suprême leader, Snoke.",
                    R.drawable.kyloren),
            new Character("Rey Skywalker",
                    "Rey Skywalker, née Rey Palpatine, était une humaine qui découvrit sa " +
                            "sensibilité à la Force alors qu'elle était à la recherche du légendaire " +
                            "Maître Jedi Luke Skywalker. Rey grandit au milieu des épaves sur Jakku, " +
                            "une planète désertique des Confins Occidentaux, où elle fut abandonnée " +
                            "par sa famille. Elle passa son enfance à rêver de retrouver un jour les " +
                            "siens tandis qu'elle devenait une pilleuse d'épaves.",
                    R.drawable.rey)
    };
}
