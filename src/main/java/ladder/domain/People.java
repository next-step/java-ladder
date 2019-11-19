package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class People {

    private List<Person> people;

    public People(String names) {
        this.people = createPeople(names);
    }

    public Person getPerson(String name) {
        return this.people.stream()
                .filter(person -> person.findNameContainsExactly(name))
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
        this.people = new ArrayList<>();
        Names peopleNames = new Names(names);
        for (int i = 0; i < peopleNames.length(); i++) {
            people.add(new Person(peopleNames.getName(i), i));
        }
        return new ArrayList<>(people);
    }

    public int size() {
        return people.size();
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }
}
