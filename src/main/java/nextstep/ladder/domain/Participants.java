package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    private static final String COMMA = ",";
    private final List<ParticipantName> names;

    public Participants(String csvNames) {
        this(csvNames.split(COMMA));
    }

    public Participants(String...names) {
        this(participantsNames(names));
    }

    public Participants(List<ParticipantName> names) {
        this.names = names;
    }

    private static List<ParticipantName> participantsNames(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .map(ParticipantName::new)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participants)) return false;
        Participants that = (Participants) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
