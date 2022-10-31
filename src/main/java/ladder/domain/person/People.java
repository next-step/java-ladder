package ladder.domain.person;

import ladder.exception.person.PeopleSizeException;
import ladder.exception.person.PersonNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class People {

    private final List<Person> people;
    private static final int PEOPLE_MIN = 2;
    private static final String FIND_ALL = "all";

    public People(String... strings) {
        if (strings.length < PEOPLE_MIN) {
            throw new PeopleSizeException();
        }
        this.people = IntStream.range(0, strings.length)
                .mapToObj(number -> new Person(strings[number], number, 0))
                .collect(Collectors.toList());
    }

    public int number() {
        return people.size();
    }

    public List<Person> people() {
        return Collections.unmodifiableList(this.people);
    }

    public List<Person> findByName(String... personNames) {
        if (isContainFindAll(personNames)) {
            return this.people;
        }
        List<Person> personList = this.people.stream()
                .filter(person -> Arrays.stream(personNames).anyMatch(Predicate.isEqual(person.name())))
                .distinct()
                .collect(Collectors.toList());
        if (personList.isEmpty()) {
            throw new PersonNotFoundException();
        }
        return Collections.unmodifiableList(personList);
    }

    private boolean isContainFindAll(String... personNames) {
        return Arrays.asList(personNames).contains(FIND_ALL);
    }
}
