package reladder.domain;


import java.util.ArrayList;
import java.util.List;

public class People {

    private List<Person> people;

    public People(String names) {
        this.people = createPeople(names);
    }

    public String getPersonName(String name) {
        return this.people.stream()
                .filter(person -> person.findNameContainsExactly(name))
                .map(Person::getName)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getPersonPosition(String name) {
        return this.people.stream()
                .filter(person -> person.findNameContainsExactly(name))
                .map(Person::getPosition)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
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
