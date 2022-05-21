package nextstep.ladder.model.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public Person person(int index) {
        return this.people.get(index);
    }

    public int size() {
        return this.people.size();
    }
}
