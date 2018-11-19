package ladder.domain.player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private static final String delimiter = ",";
    private List<Person> people;

    public People(String line) {
        people = Arrays.asList(line.split(delimiter))
                .stream()
                .map(person -> new Person(person))
                .collect(Collectors.toList());
    }

    public List<Person> getPeople() {
        return people;
    }

    public int peopleCount() {
        return people.size();
    }

    public Person getPerson(int count) {
        return this.people.get(count);
    }

    public int getCountForPerson(Person resultPerson) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).equals(resultPerson)) {
                return i;
            }
        }
        return 0;
    }
}
