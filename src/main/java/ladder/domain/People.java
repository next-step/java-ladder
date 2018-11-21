package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private static final String SEPARATOR = ",";
    private List<Person> people;

    private People(String line) {
        people = Arrays.asList(line.split(SEPARATOR))
                    .stream()
                    .map(Person::from)
                    .collect(Collectors.toList());
    }

    public static People from(String line) {
        return new People(line);
    }

    public List<Person> getPeople() {
        return people;
    }

    public int peopleCount() {
        return people.size();
    }
}
