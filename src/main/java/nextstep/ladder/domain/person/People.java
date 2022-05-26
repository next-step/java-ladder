package nextstep.ladder.domain.person;

import nextstep.ladder.util.StringSpliter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class People {
    private static final int MIN_PEOPLE_COUNT = 2;

    private final List<Person> people;

    public People(List<Person> people) {
        validatePeopleCount(people);
        this.people = people;
    }

    private void validatePeopleCount(List<Person> people) {
        if (people.size() < MIN_PEOPLE_COUNT) {
            throw new IllegalArgumentException("[ERROR] 참여자는 " + MIN_PEOPLE_COUNT + "명 이상이어야 합니다.");
        }
    }

    public static People from(String newNames) {
        List<String> names = StringSpliter.split(newNames);
        List<Person> people = peopleList(names);
        return new People(people);
    }

    private static List<Person> peopleList(List<String> names) {
        List<Person> people = new ArrayList<>();
        Person person = Person.first(names.get(0));
        people.add(person);

        for (int index = 1; index < names.size(); index++) {
            person = person.next(names.get(index));
            people.add(person);
        }
        return people;
    }

    public Person person(String name) {
        Name findName = new Name(name);
        return people.stream()
                .filter(person -> person.equalName(findName))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("[ERROR] 존재하지 않는 참가자입니다.");
                });
    }

    public List<Person> people() {
        return Collections.unmodifiableList(people);
    }

    public int size() {
        return people.size();
    }

    @Override
    public String toString() {
        return people.stream()
                .map(Person::toString)
                .collect(Collectors.joining()) + "\n";
    }
}
