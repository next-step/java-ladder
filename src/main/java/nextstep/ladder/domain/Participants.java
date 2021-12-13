package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        checkMinimumNumber(participants);
        this.participants = participants;
    }

    public static Participants of(String participants) {
        return new Participants(Arrays.asList(participants.split(",")).stream()
                .map(participant -> Participant.of(participant))
                .collect(Collectors.toList()));
    }

    public int getParticipantsSize() {
        return participants.size();
    }

    private void checkMinimumNumber(List<Participant> participants) {
        if (participants.size() < 2) {
            throw new IllegalArgumentException("2명보다 적은 참가자는 게임할 수 없습니다.");
        }
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

}
