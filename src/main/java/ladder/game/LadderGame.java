package ladder.game;

import java.util.Arrays;
import java.util.Collections;
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

    public LadderGame(String participants, int ladderHeight, ConnectionStrategy connectionStrategy) {
        this.participants = verifyParticipants(participants);
        this.ladder = new Ladder(this.participants.size(), verityLadderHeight(ladderHeight), connectionStrategy);
    }

    public boolean isConnected(int line, int width) {
        return ladder.isConnected(line, width);
    }

    public int getLadderHeight() {
        return ladder.getLadderHeight();
    }

    public int getLadderWidth() {
        return participants.size() - 1;
    }

    public List<String> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    private List<String> verifyParticipants(String inputParticipants) {
        List<String> participants
                = Arrays.stream(inputParticipants.split(DELIMITER))
                .map(participant -> participant.trim())
                .collect(toList());
        if (participants.stream().anyMatch(participant -> participant.length() > PARTICIPANT_NAME_MAX_LENGTH)) {
            throwExceptions(PARTICIPANT_NAME_MAX_LENGTH_EXCEPTION, PARTICIPANT_NAME_MAX_LENGTH);
        }
        if (participants.size() < PARTICIPANT_MIN_SIZE) {
            throwExceptions(PARTICIPANTS_MIN_SIZE_EXCEPTION, PARTICIPANT_MIN_SIZE);
        }
        return participants;
    }

    private int verityLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throwExceptions(LADDER_HEIGHT_EXCEPTION);
        }
        return ladderHeight;
    }

    private void throwExceptions(String pattern, Object... elements) {
        throw new IllegalArgumentException(String.format(pattern, elements));
    }
}
