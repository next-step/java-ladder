package nextstep.laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<String> participants) {
       this.participants = IntStream.range(0, participants.size())
                .mapToObj(position -> new Participant(participants.get(position), position))
                .collect(Collectors.toList());

    }

    public List<Participant> values() {
        return participants;
    }
}
