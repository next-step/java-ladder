package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Name> names;

    private Participants(List<String> names) {
        this.names = names.stream()
                .map(Name::valueOf)
                .collect(Collectors.toList());
    }

    public static Participants from(List<String> names) {
        return new Participants(names);
    }

    public NumberOfParticipants getNumberOfParticipants() {
        return NumberOfParticipants.valueOf(names.size());
    }
}
