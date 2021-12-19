package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        checkMinimumNumber(participants);
        this.participants = participants;
    }

    public static Participants of(String participants) {
        AtomicInteger index = new AtomicInteger();
        return new Participants(Arrays.asList(participants.split(",")).stream()
                .map(participant -> Participant.of(participant, index.getAndIncrement()))
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

    public int getParticipantIndex(String participant) {
        for (int index = 0; index < participants.size(); index++) {
            if (participants.get(index).getParticipant() == participant) {
                return index;
            }
        }
        throw new IllegalArgumentException("해당하는 유저가 없습니다.");
    }
}
