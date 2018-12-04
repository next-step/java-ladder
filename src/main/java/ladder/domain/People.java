package ladder.domain;

import ladder.exception.NotFindMatchNameException;

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

    public int size() {
        return people.size();
    }

    public Person findPersonBy(int number) {
        return people.get(number);
    }

    public Position findPositionBy(String name) {
        int index = people.indexOf(Person.from(name));

        if(index < 0)
            throw new NotFindMatchNameException();

        return Position.from(index);
    }
}
