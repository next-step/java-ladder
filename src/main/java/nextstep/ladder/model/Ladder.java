package nextstep.ladder.model;

import java.util.List;

public class Ladder {
    private String[] people;
    private int height;
    private Lines lines;

    public Ladder(String people, int height){
        this.people = people.split(",");
        this.height = height;
    }





}
