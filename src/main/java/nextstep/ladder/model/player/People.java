package nextstep.ladder.model.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class People {

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

    public int sequence(String name) {
        return IntStream
                .range(0, this.people.size())
                .filter(index -> this.person(index).equals(name))
                .boxed()
                .findFirst()
                .orElseThrow(() -> new NullPointerException(String.format("%s 의 참여자를 찾을 수 없습니다.", name)));
    }

    public Person person(int index) {
        return this.people.get(index);
    }

    public int size() {
        return this.people.size();
    }
}
