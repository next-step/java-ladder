package step2.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Participants {
    private List<Person> participants;

    private Participants(List<Person> participants) {
        this.participants = participants;
    }

    public static Participants of(List<Person> people) {
        return new Participants(people);
    }

    public static Participants of(String[] names) {
        return Arrays.stream(names)
                .map(Person::new)
                .collect(collectingAndThen(toList(), Participants::of));
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
