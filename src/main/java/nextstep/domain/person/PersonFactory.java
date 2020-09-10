package nextstep.domain.person;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PersonFactory {

    public static final String DELIMITER = ",";

    private PersonFactory() {

    }

    public static Participants createPersons(String line) {
        return createPersons(line.split(DELIMITER));
    }

    public static Participants createPersons(String[] names) {
        return new Participants(Arrays.stream(names)
                .map(Person::new)
                .collect(Collectors.toList()));
    }

}
