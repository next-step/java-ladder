package ladder.game;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderGame {
    private static final String DELIMITER = ",";
    private static final int PARTICIPANT_NAME_MAX_LENGTH = 5;
    private static final String PARTICIPANT_NAME_MAX_LENGTH_EXCEPTION = "참여자의 이름은 %d글자를 넘을 수 없습니다";
    private static final int PARTICIPANT_MIN_SIZE = 2;
    private static final String PARTICIPANTS_MIN_SIZE_EXCEPTION = "참여자는 최소 %d명 입니다.";
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";

    private Ladder ladder;
    private List<String> participants;

    public LadderGame(String participants, int ladderHeight) {
        this.participants = verifyParticipants(participants);
        this.ladder = new Ladder(this.participants.size(), verityLadderHeight(ladderHeight));
    }

    private List<String> verifyParticipants(String inputParticipants) {
        List<String> participants
                = Arrays.stream(inputParticipants.split(DELIMITER))
                .map(participant -> participant.trim())
                .collect(toList());
        if (participants.stream().anyMatch(participant -> participant.length() > 5)) {
            throw new IllegalArgumentException
                    (String.format(PARTICIPANT_NAME_MAX_LENGTH_EXCEPTION, PARTICIPANT_NAME_MAX_LENGTH));
        }
        if (participants.size() < PARTICIPANT_MIN_SIZE) {
            throw new IllegalArgumentException
                    (String.format(PARTICIPANTS_MIN_SIZE_EXCEPTION, PARTICIPANT_MIN_SIZE));
        }
        return participants;
    }

    private int verityLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LADDER_HEIGHT_EXCEPTION);
        }
        return ladderHeight;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getParticipants() {
        return participants;
    }
}
