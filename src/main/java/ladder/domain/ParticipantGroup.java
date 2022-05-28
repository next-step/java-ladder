package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ParticipantGroup {
    private static final int MIN_PARTICIPANTS = 2;

    private final List<Participant> participants;

    public ParticipantGroup(List<Participant> participants) {
        validateParticipants(participants);
        this.participants = participants;
    }

    private void validateParticipants(List<Participant> participants) {
        if (participants == null) {
            throw new IllegalArgumentException("참가자들은 null 일 수 없습니다.");
        }
        validateParticipantsCount(participants.size());
        validateDuplicateName(participants);
    }

    private void validateParticipantsCount(int participantsCount) {
        if (participantsCount < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException(String.format("사다리 게임 참가자는 2명 미만일 수 없습니다. 현재 참가자 수 : %d", participantsCount));
        }
    }

    private void validateDuplicateName(List<Participant> participants) {
        Set<Participant> nonDuplicateParticipant = new HashSet<>(participants);
        if (nonDuplicateParticipant.size() != participants.size()) {
            throw new IllegalArgumentException(String.format("참가자 이름은 중복될 수 없습니다. 참가자한 사람 이름 : %s", participants));
        }
    }

    public List<String> participantNames() {
        return participants.stream().map(Participant::name).collect(Collectors.toList());
    }

    public int participantsCount() {
        return participants.size();
    }

    public int maxParticipantNameLength() {
        return participants.stream().mapToInt(Participant::nameLength).max().getAsInt();
    }
}
