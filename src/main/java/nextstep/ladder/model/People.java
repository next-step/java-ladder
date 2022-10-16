package nextstep.ladder.model;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Set;

public class People {
    private static final String DUPLICATE_PEOPLE_NAME_EXCEPTION_MESSAGE = "중복된 이름이 존재할 수 없습니다.";
    private static final String MINIMUM_REQUIRED_PEOPLE_EXCEPTION_MESSAGE = "최소 2명 이상의 인원이 존재해야 합니다.";

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

    public int getPeopleCount() {
        return people.size();
    }

    private void validate(List<String> peopleNames) {
        if (peopleNames.size() != people.size()) {
            throw new IllegalArgumentException(DUPLICATE_PEOPLE_NAME_EXCEPTION_MESSAGE);
        }

        if (people.size() < 2) {
            throw new IllegalArgumentException(MINIMUM_REQUIRED_PEOPLE_EXCEPTION_MESSAGE);
        }
    }
}
