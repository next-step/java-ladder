package ladder.game;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class GameInfo {
    private static final String RESULT_SIZE_EXCEPTION = "사다리게임의 결과는 사다리 참여자와 동일한 개수여야 합니다.";
    private final Participants participants;
    private final Prizes prizes;

    private GameInfo(Participants participants, Prizes prizes) {
        this.participants = participants;
        verifyPrizesCount(participants.size(), prizes);
        this.prizes = prizes;
    }

    public GameInfo(String inputParticipant, String inputResults) {
        this(new Participants(inputParticipant),
                new Prizes(Arrays.stream(inputResults.split(","))
                        .map(String::trim).collect(toList())));
    }

    private static void verifyPrizesCount(int participantsSize, Prizes prizes) {
        if (prizes.size() != participantsSize) {
            throw new IllegalArgumentException(RESULT_SIZE_EXCEPTION);
        }
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
