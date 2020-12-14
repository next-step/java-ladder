package ladder.domain;

import java.util.Map;

public class GameResult {
    private final Map<String, String> results;
    private final LadderGameInformation ladderGameInformation;

    public GameResult(Map<String, String> results, LadderGameInformation ladderGameInformation) {
        this.results = results;
        this.ladderGameInformation = ladderGameInformation;
    }
}
