package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public Participants(String names) {
        this(Arrays.stream(names.split(","))
                .map(Participant::new)
                .collect(Collectors.toList()));
    }

    public List<String> getParticipantNames() {
        return participants.stream()
                .map(participant -> participant.getName())
                .collect(Collectors.toList());
    }

    public int getParticipantCount() {
        return participants.size();
    }
}
