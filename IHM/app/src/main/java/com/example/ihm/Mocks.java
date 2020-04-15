package com.example.ihm;

import java.time.LocalDateTime;

public interface Mocks {

    Event[] EVENTS=new Event[]{
            new Event("Anchois",
                    LocalDateTime.of(2020,3,15,7,0),
                    LocalDateTime.of(2020,3,15,10,0)),
            new Event("Saumon",
                    LocalDateTime.of(2020,4,21,5,0),
                    LocalDateTime.of(2020,4,21,6,30)),
            new Event("Sardine",
                    LocalDateTime.of(2020,4,21,5,0),
                    LocalDateTime.of(2020,4,21,6,30))
    };
}
