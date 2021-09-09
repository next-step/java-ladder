package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public Participants(String[] names) {
        this(IntStream.range(0, names.length)
                .mapToObj((i) -> new Participant(names[i], i))
                .collect(Collectors.toList()));
    }

    public int getCountOfParticipants() {
        return participants.size();
    }

    public List<Participant> getPaticipants() {
        return participants;
    }
}
