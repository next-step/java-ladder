package ladder;

import java.util.ArrayList;
import java.util.List;

public class People {
    private static final String COMMA = ",";

    List<Person> people;

    private People(String people) {
        this.people = new ArrayList<>();

        String[] peopleArray = people.split(COMMA);
        for(int i = 0; i < peopleArray.length; i++) {
            this.people.add(Person.of(peopleArray[i]));
        }
    }

    public static People of(String names) {
        return new People(names);
    }

    public int count() {
        return people.size();
    }

}
