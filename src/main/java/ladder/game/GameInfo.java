package ladder.game;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class GameInfo {
    private static final String RESULT_SIZE_EXCEPTION = "사다리게임의 결과는 사다리 참여자와 동일한 개수여야 합니다.";
    private final Participants participants;
    private final Prizes prizes;

    public GameInfo(String inputParticipant, String inputResults) {
        this.participants = new Participants(inputParticipant);
        List<String> results = verifyResult(inputResults, this.participants.size());
        this.prizes = new Prizes(results);
    }

    private static List<String> verifyResult(String inputResults, int participantsSize) {
        List<String> results = Arrays.stream(inputResults.split(","))
                .map(String::trim).collect(toList());
        if (results.size() != participantsSize) {
            throw new IllegalArgumentException(RESULT_SIZE_EXCEPTION);
        }
        return results;
    }

    public int sizeOfParticipants() {
        return this.participants.size();
    }

    public Participants getParticipants() {
        return participants;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
