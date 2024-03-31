package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    private final List<ParticipantV2> participants;

    public Participants(String names) {
        this(names.split(","));
    }

    public Participants(String[] names) {
        this(generateNames(names));
    }

    public Participants(List<ParticipantV2> participants) {
        if(participants.size() <= 1){
            throw new IllegalArgumentException();
        }
        this.participants = participants;
    }

    private static List<ParticipantV2> generateNames(String[] names){
        return Arrays.stream(names)
                .map(ParticipantV2::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participants)) return false;
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }
}
