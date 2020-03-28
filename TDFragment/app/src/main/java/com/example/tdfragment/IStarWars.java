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
                    R.drawable.kyloren)
    };
}
