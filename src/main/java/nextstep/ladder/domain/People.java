package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class People {

    private final List<Person> people;

    public People(String[] names) {
        this.people = IntStream.range(0, names.length)
                .mapToObj(sequence -> new Person(names[sequence]))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Person> people() {
        return people;
    }
}
