package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Person> participants;

    public static Participants of(List<String> names) {
        List<Person> persons = names.stream()
                .map(Person::new)
                .collect(Collectors.toUnmodifiableList());
        return new Participants(persons);
    }

    private Participants(List<Person> persons) {
        this.participants = persons;
    }

    public int getSize() {
        return this.participants.size();
    }
}
