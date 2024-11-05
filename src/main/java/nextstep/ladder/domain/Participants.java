package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<String> names() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public int findParticipantIndex(String name) {
        return IntStream.range(0, participants.size())
                .filter(i -> participants.get(i).matchName(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int size() {
        return participants.size();
    }
}
