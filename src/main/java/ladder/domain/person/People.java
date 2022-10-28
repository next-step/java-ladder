package ladder.domain.person;

import ladder.exception.person.PeopleSizeException;
import ladder.exception.person.PersonNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people;
    private static final int PEOPLE_MIN = 2;
    private final String FIND_ALL = "all";

    public People(String... strings) {
        if (strings.length < PEOPLE_MIN) {
            throw new PeopleSizeException();
        }
        this.people = Arrays.stream(strings)
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public int number() {
        return people.size();
    }

    public List<String> toStrings() {
        return people.stream()
                .map(Person::toString)
                .collect(Collectors.toList());
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
