package ladder.domain;


import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
    private static final String SEPARATOR = ",";

    private final List<Participant> participants;

    public Participants(String text) {
        this(text.split(SEPARATOR));
    }

    public Participants(String[] names) {
        this(IntStream.range(0, names.length)
                .mapToObj(i -> new Participant(names[i], i))
                .collect(Collectors.toList()));
    }

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int size() {
        return this.participants.size();
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    public List<String> getParticipantNames() {
        return Collections.unmodifiableList(this.participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList()));
    }

    public Participant getParticipant(String name) {
        return participants.stream().filter(p -> p.hasSameName(name))
                .findFirst().orElseThrow(
                        () -> new IllegalArgumentException("해당 이름의 참가자가 없습니다.")
                );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }
}
