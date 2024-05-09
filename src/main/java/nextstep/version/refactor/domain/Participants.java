package nextstep.version.refactor.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    public Participants(String names) {
        this(createParticipants(names));
    }

    private static List<Participant> createParticipants(String names) {
        String[] namesArray = names.split(",");
        return Arrays.stream(namesArray)
                .map(Participant::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public Participant get(int index) {
        return this.participants.get(index);
    }

    public int size() {
        return this.participants.size();
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
        return Objects.hashCode(participants);
    }

    public List<String> getNameList() {
        return this.participants.stream().map(Participant::getName).collect(Collectors.toList());
    }
}
