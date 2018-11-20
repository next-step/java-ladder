package ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class People {
    private static final String COMMA = ",";

    private List<Person> people;

    private People(String people) {
        this.people = new ArrayList<>();

        Arrays.asList(people.split(COMMA)).stream()
                .forEach(name -> this.people.add(Person.of(name)));
    }

    public static People of(String names) {
        return new People(names);
    }

    public int count() {
        return people.size();
    }

}
