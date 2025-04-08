package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    List<Participant> values;

    public Participants(List<String> names) {
        this.values = names.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public List<String> getParticipantsName() {
        return this.values.stream().map(Participant::getName)
                .collect(Collectors.toList());
    }
}
