package nextstep.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Participants {
    List<Participant> participants = new ArrayList<Participant>();

    public static Participants create(String names) {
        String[] namesArray = names.split(",");
        return new Participants(Arrays.stream(namesArray)
                .map(Participant::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Participant> getList() {
        return this.participants;
    }

    public List<String> getNames() {
        return this.participants.stream().map(Participant::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int countOfPerson() {
        return this.participants.size();
    }
}
