package nextstep.domain.person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonFactory {

    public static final String DELIMITER = ",";

    private PersonFactory() {

    }

    public static List<Person> createPersons(String line) {
        return createPersons(line.split(DELIMITER));
    }

    public static List<Person> createPersons(String[] names) {
        return Arrays.stream(names)
                .map(Person::new)
                .collect(Collectors.toList());
    }

}
