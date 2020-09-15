package nextstep.domain.person;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PersonFactory {

    public static final String DELIMITER = ",";

    private PersonFactory() {

    }

    public static Participants createPersons(String line) {
        return createPersons(line.split(DELIMITER));
    }

    public static Participants createPersons(String[] names) {
        return new Participants(IntStream.range(0, names.length)
                .mapToObj(i -> new Person(i, names[i]))
                .collect(Collectors.toList()));
    }

}
