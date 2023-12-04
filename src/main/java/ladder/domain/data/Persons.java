package ladder.domain.data;

import java.util.ArrayList;
import java.util.List;

public class Persons {

    private List<Person> persons;

    public Persons(PersonNames personNames, Goals goals) {
        //this();
    }

    public Persons(List<Person> persons) {
        this.persons = new ArrayList<>(persons);
    }
}
