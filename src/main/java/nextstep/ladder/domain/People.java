package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class People {
    public final List<Person> people;

    public People(List<Person> people) {
        checkPeopleSize(people);
        this.people = people;
    }

    private void checkPeopleSize(List<Person> people) {
        if (people.size() <= 1) {
            throw new IllegalArgumentException("참여자는 2명 이상으로 설정 하세요");
        }
    }

    @Override
    public String toString() {
        return String.join("", this.people.stream()
                .map(Person::toString)
                .collect(Collectors.toList()));
    }
}