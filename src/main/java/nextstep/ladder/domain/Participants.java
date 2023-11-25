package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Name> names;

    public Participants(List<String> persons) {
        this.names = persons.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Name> names() {
        return Collections.unmodifiableList(names);
    }

    public int countOfParticipant() {
        return names.size();
    }
}
