package nextstep.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonFactory {

    public static final String DELIMITER = ",";

    private PersonFactory() {

    }

    public static Person createPerson(String name) {
        return new Person(name);
    }

    public static List<Person> createPersons(String[] names) {
        return Arrays.stream(names)
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public static List<Person> createPersons(String line) {
        return Arrays.stream(line.split(DELIMITER))
                .map(Person::new)
                .collect(Collectors.toList());
    }

}
