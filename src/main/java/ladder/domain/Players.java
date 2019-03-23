package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String COMMA = ",";

    private List<Person> people;

    public Players(List<Person> people) {
        this.people = people;
    }

    public static Players generate(String names) {
        return new Players(Arrays.stream(names.split(COMMA))
            .map(String::trim)
            .map(Person::new)
            .collect(Collectors.toList()));
    }

    public int size() {
        return this.people.size();
    }
}
