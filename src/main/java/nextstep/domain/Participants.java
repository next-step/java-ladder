package nextstep.domain;

import java.util.Collections;
import java.util.List;

public class Participants {

    private final List<Person> persons;

    public Participants(List<Person> persons) {
        this.persons = persons;
    }

    public int getTrackNumberByPersonName(String personName) {
        return persons.indexOf(new Person(personName));
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }

    public String getPersonName(int index) {
        return persons.get(index).getName();
    }

    public int getPersonSize() {
        return persons.size();
    }

}
