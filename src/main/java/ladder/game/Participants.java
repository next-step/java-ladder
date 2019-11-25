package ladder.game;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Participants {
    private static final String DELIMITER = ",";
    private static final String PARTICIPANTS_MIN_SIZE_EXCEPTION = "참여자는 최소 %d명 입니다.";
    private static final int PARTICIPANT_MIN_SIZE = 2;
    private final List<Participant> participants;

    public Participants(String participants) {
        this.participants = verifyParticipants(participants);
    }

    private static List<Participant> verifyParticipants(String inputParticipants) {
        List<Participant> participants = Arrays.stream(inputParticipants.split(DELIMITER))
                .map(String::trim)
                .map(Participant::new)
                .collect(toList());
        if (participants.size() < PARTICIPANT_MIN_SIZE) {
            throw new IllegalArgumentException(
                    String.format(PARTICIPANTS_MIN_SIZE_EXCEPTION, PARTICIPANT_MIN_SIZE));
        }
        return participants;
    }

    public int size() {
        return participants.size();
    }

    public List<String> getNames() {
        return participants.stream().map(Participant::toString)
                .collect(toList());
    }

    public int indexOf(String user) {
        int index = participants.indexOf(new Participant(user));
        if (index < 0) {
            throw new IllegalArgumentException("제대로 된 이름을 입력하세요 ");
        }
        return index;
    }
}
