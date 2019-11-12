package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.ConnectionStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderGame {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";
    private static final String RESULT_SIZE_EXCEPTION = "사다리게임의 결과는 사다리 참여자와 동일한 개수여야 합니다.";
    private static final String RESULT_LENGTH_EXCEPTION = "사다리게림의 결과는 5자를 넘을 수 없습니다";

    private Ladder ladder;
    private Participants participants;
    private List<String> results;

    public LadderGame(String inputParticipant, int ladderHeight, ConnectionStrategy connectionStrategy) {
        this.participants = Participants.of(inputParticipant);
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
        return Collections.unmodifiableList(participants.getNames());
    }

    private int verityLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LADDER_HEIGHT_EXCEPTION);
        }
        return ladderHeight;
    }

    public void setResults(String inputResults) {
        List<String> results = Arrays.stream(inputResults.split(",")).map(String :: trim).collect(toList());
        if ( results.size() != participants.size() ) {
            throw new IllegalArgumentException(RESULT_SIZE_EXCEPTION);
        }
        if ( results.stream().anyMatch(result -> result.length() > 5) ) {
            throw new IllegalArgumentException(RESULT_LENGTH_EXCEPTION);
        }
        this.results = results;
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }
}
