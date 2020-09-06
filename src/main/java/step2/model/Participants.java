package step2.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private List<Person> participants;

    public Participants(String[] names) {
        this.participants = Arrays.stream(names)
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public Person findPersonByName(String name) {
        return participants.stream()
                .filter(it -> it.printName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                ;
    }

    public int getNumberOfParticipants() {
        return participants.size();
    }

    public String toString() {
        return participants.stream()
                .map(Person::printName)
                .collect(Collectors.joining(" "))
                ;
    }

}
