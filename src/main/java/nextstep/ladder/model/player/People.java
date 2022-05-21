package nextstep.ladder.model.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.model.ConstantNumber.ZERO;

public class People {

    private static final String NOT_FOUND_SEQUENCE_MESSAGE = "%s 의 참여자를 찾을 수 없습니다.";

    private final List<Person> people;

    private People(List<Person> people) {
        this.people = people;
    }

    public static People of(List<String> names) {
        List<Person> people = names
                .stream()
                .map(Person::of)
                .collect(Collectors.toList());

        return new People(people);
    }

    public List<Person> unwrap() {
        return Collections.unmodifiableList(this.people);
    }

    public int findSequence(String name) {
        return IntStream
                .range(ZERO.getValue(), this.people.size())
                .filter(index -> this.person(index).equals(name))
                .boxed()
                .findFirst()
                .orElseThrow(() -> new NullPointerException(String.format(NOT_FOUND_SEQUENCE_MESSAGE, name)));
    }

    public Person person(int index) {
        return this.people.get(index);
    }

    public int size() {
        return this.people.size();
    }
}
