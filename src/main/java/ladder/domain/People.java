package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private static final String DELIMITER = ",";
    private List<Person> people = new ArrayList<>();

    public People(String names) {
        this.people = createPeople(names);
        validate();
    }

    public Person getPerson(String name) {
        return this.people.stream()
                .filter(person -> person.isName(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Person> matchResult(List<Line> lines) {
        List<Person> peopleWithResult = new ArrayList<>();
        for (Person person : this.people) {
            peopleWithResult.add(person.result(lines));
        }
        return peopleWithResult;
    }

    private List<Person> createPeople(String names) {
        String[] peopleNames = names.split(DELIMITER);
        for (int i = 0; i < peopleNames.length; i++) {
            people.add(new Person(peopleNames[i], i));
        }
        return people;
    }

    private void validate() {
        this.people.forEach(Person::validate);
    }

    public int size() {
        return people.size();
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }
}
