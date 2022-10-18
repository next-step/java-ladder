package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderParser {

    public static List<Person> listPerson(String[] names) {
        return Arrays.stream(names)
                .map(Person::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
