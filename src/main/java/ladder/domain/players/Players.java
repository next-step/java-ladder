package ladder.domain.players;

import ladder.common.Constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Person> people;

    private Players(List<Person> people) {
        this.people = people;
    }

    public static Players generate(String names) {
        return new Players(Arrays.stream(names.split(Constants.COMMA))
            .map(String::trim)
            .map(Person::new)
            .collect(Collectors.toList()));
    }

    public int size() {
        return this.people.size();
    }

    public Person getPersonByIndex(int index) {
        return this.people.get(index);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }
}
