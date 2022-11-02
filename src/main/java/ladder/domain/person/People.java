package ladder.domain.person;

import ladder.domain.person.name.SearchPeopleNames;
import ladder.exception.person.PeopleSizeException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class People {

    private final List<Person> people;
    private static final int PEOPLE_MIN = 2;

    public People(String... strings) {
        validPeopleSize(strings);
        this.people = IntStream.range(0, strings.length)
                .mapToObj(number -> new Person(strings[number], number, 0))
                .collect(Collectors.toList());
    }

    private static void validPeopleSize(String[] strings) {
        if (strings.length < PEOPLE_MIN) {
            throw new PeopleSizeException();
        }
    }

    public int number() {
        return people.size();
    }

    public List<Person> findAllBySearchPeopleNames(SearchPeopleNames searchPeopleNames) {
        if (searchPeopleNames.isFindAll()) {
            return this.people();
        }
        return Collections.unmodifiableList(findPersons(searchPeopleNames));
    }

    private List<Person> findPersons(SearchPeopleNames peopleNames) {
        return this.people.stream()
                .filter(person -> peopleNames.peopleNames().contains(person.name()))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Person> people() {
        return Collections.unmodifiableList(this.people);
    }
}
