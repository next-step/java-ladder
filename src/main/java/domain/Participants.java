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

    public List<Participant> getValues() {
        return this.values;
    }
}
