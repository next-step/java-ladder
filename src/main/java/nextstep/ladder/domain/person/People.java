package nextstep.ladder.domain.person;

import nextstep.ladder.util.StringSpliter;

import java.util.List;
import java.util.stream.Collectors;

public class People {
    private final List<Person> people;

    public People(List<Person> people) {
        validatePeopleCount(people);
        this.people = people;
    }

    private void validatePeopleCount(List<Person> people) {
        if (people.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 참여자는 2명 이상이어야 합니다.");
        }
    }

    public static People of(String names) {
        List<Person> people = StringSpliter.split(names)
                .stream().map(Person::new)
                .collect(Collectors.toList());
        return new People(people);
    }

    @Override
    public String toString() {
        return people.stream()
                .map(Person::toString)
                .collect(Collectors.joining());
    }
}
