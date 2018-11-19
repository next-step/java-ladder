package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private static final String delimiter = ",";
    private List<Person> people;

    public People(String line) {
        people = Arrays.asList(line.split(delimiter))
                .stream()
                .map(person -> new Person(person))
                .collect(Collectors.toList());
    }

    public List<Person> getPeople() {
        return people;
    }

    public int peopleCount() {
        return people.size();
    }
}
