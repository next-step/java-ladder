package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {

    public static final String ALL_PARTICIPANTS = "all";
    public static final String NO_TARGET_EQUATION_EXCEPTION = "타겟 참가자와 일치하는 이름을 가진 참가자가 존재하지 않습니다.";
    private final List<Participant> participants;

    public Participants(List<String> participantNames) {
        this.participants = IntStream.range(0, participantNames.size())
                .mapToObj(position -> new Participant(participantNames.get(position), position))
                .collect(Collectors.toList());
    }

    public Participants(Participant participant) {
        this.participants = List.of(participant);
    }

    public Participants createParticipants(String target) {
        if (ALL_PARTICIPANTS.equals(target)) {
            return getAllParticipants();
        }
        return createTargetParticipants(target);
    }

    private Participants getAllParticipants() {
        return this;
    }

    private Participants createTargetParticipants(String target) {
        return this.participants.stream()
                .filter(p -> p.isSameName(target))
                .findFirst()
                .map(Participants::new)
                .orElseThrow(() -> new IllegalStateException(NO_TARGET_EQUATION_EXCEPTION));
    }

    public List<Participant> startLadderGame(Ladder ladder) {
        return this.participants.stream()
                .map(ladder::startGame)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }

    @Override
    public String toString() {
        return "Participants{" +
                "participants=" + participants +
                '}';
    }
}
