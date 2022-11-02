package ladder.domain.person;

import ladder.exception.person.PeopleSizeException;

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

    public List<Person> findByName(SearchPeopleNames searchPeopleNames) {
        List<String> textPersonNames = searchPeopleNamesToText(searchPeopleNames);

        if (isFindAll(textPersonNames)) {
            return this.people();
        }
        return Collections.unmodifiableList(findPersons(textPersonNames));
    }

    private List<String> searchPeopleNamesToText(SearchPeopleNames searchPeopleNames) {
        List<PersonName> personNames = searchPeopleNames.peopleNames();
        return personNames.stream()
                .map(PersonName::name)
                .collect(Collectors.toList());
    }

    private List<Person> findPersons(List<String> peopleNames) {
        return this.people.stream()
                .filter(person -> peopleNames.stream().anyMatch(Predicate.isEqual(person.name())))
                .distinct()
                .collect(Collectors.toList());
    }

    private boolean isFindAll(List<String> peopleNames) {
        return peopleNames.contains(FIND_ALL);
    }

    public List<Person> people() {
        return Collections.unmodifiableList(this.people);
    }
}
