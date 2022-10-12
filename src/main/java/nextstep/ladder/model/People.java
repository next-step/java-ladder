package nextstep.ladder.model;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Set;

public class People {
    private final Set<Person> people;

    public People(List<String> peopleNames) {
        this.people = peopleNames.stream()
            .map(Person::new)
            .collect(toSet());
        validate(peopleNames);
    }

    public List<String> getPeopleNames() {
        return people.stream()
            .map(Person::getName)
            .collect(toList());
    }

    private void validate(List<String> peopleNames) {
        if (peopleNames.size() != people.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재할 수 없습니다.");
        }

        if (people.size() < 2) {
            throw new IllegalArgumentException("최소 2명 이상의 인원이 존재해야 합니다.");
        }
    }
}
