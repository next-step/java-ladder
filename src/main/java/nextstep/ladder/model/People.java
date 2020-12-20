package nextstep.ladder.model;

import java.util.Arrays;

public class People {
    private String[] people;

    public People(String people){
        this.people = Arrays.stream(people.split(","))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public String[] getPeople(){
        return people;
    }

}
