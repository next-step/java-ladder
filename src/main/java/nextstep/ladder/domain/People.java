package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class People {

    private static final int BEGIN_INDEX = 0;

    private final List<Person> people;

    public People(List<Person> people) {
        if (people.size() == 0) {
            throw new IllegalStateException("사람 이름이 입력되지 않았습니다.");
        }
        this.people = people;
    }

    public People(String[] people) {
        this(Arrays.stream(people).
                map(Person::new).
                collect(Collectors.toList()));
    }

    public int firstNameLength() {
        Optional<Person> firstPerson = Optional.ofNullable(people.get(BEGIN_INDEX));
        return firstPerson.map(person -> person.name().length()).orElse(0);
    }

    public List<Person> value() {
        return people;
    }

    @Override
    public String toString() {
        return "People{" +
                "people=" + people +
                '}';
    }

}
