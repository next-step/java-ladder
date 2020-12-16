package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private final List<Person> participants;

    public Participants(String names) {
        this.participants = new ArrayList<>();
        String[] splitNames = split(names);
        for (String name : splitNames) {
            this.participants.add(Person.from(name));
        }
    }

    private String[] split(String names) {
        return names.split(",");
    }

    public List<Person> getParticipants() {
        return participants;
    }
}
