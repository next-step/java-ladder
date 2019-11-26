package reladder.domain;


import java.util.ArrayList;
import java.util.List;

public class People {

    private List<Person> people;

    public People(String names) {
        this.people = createPeople(names);
    }

    public String getPersonName(String name) {
        return people.stream()
                .filter(person -> person.matchNameContainsExactly(name))
                .map(Person::getName)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getPersonPosition(String name) {
        return people.stream()
                .filter(person -> person.matchNameContainsExactly(name))
                .map(Person::getPosition)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    private List<Person> createPeople(String names) {
        people = new ArrayList<>();
        Names peopleNames = new Names(names);
        int length = peopleNames.length();
        for (int i = 0; i < length; i++) {
            people.add(new Person(peopleNames.getName(i), i));
        }
        return people;
    }

    public int size() {
        return people.size();
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }
}
