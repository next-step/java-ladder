package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantGroup {
    private static final int MIN_PARTICIPANTS = 2;

    private final List<Participant> participants;

    public ParticipantGroup(List<Participant> participants) {
        validateParticipants(participants);
        this.participants = participants;
    }

    public static ParticipantGroup create(List<String> participantNames) {
        return new ParticipantGroup(participantNames.stream().map(Participant::create).collect(Collectors.toList()));
    }

    public int participantsCount() {
        return participants.size();
    }

    public int maxParticipantNameLength() {
        return participants.stream().mapToInt(Participant::nameLength).max().getAsInt();
    }

    private void validateParticipants(List<Participant> participants) {
        if (participants == null) {
            throw new IllegalArgumentException("참가자들은 null 일 수 없습니다.");
        }
        validateParticipantsCount(participants.size());
    }

    private void validateParticipantsCount(int participantsCount) {
        if (participantsCount < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException(String.format("사다리 게임 참가자는 2명 미만일 수 없습니다. 현재 참가자 수 : %d", participantsCount));
        }
    }
}
