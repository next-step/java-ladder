package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;

public class Ladder {
    private String[] people;
    private int height;
    private Lines lines;

    public Ladder(String people, int height){
        this.people = Arrays.stream(people.split(","))
                            .map(String::trim)
                            .toArray(String[]::new);
        this.height = height;
        lines = new Lines(this.people.length, this.height);

    }

    public String[] getPeople(){
        return people;
    }


    public Lines getLines(){
        return lines;
    }



}
