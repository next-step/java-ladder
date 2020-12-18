package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final LadderGameInformation ladderGameInformation;
    private final Ladder ladder;

    public LadderGame(LadderGameInformation ladderGameInformation, LadderSize ladderSize) {
        this.ladderGameInformation = ladderGameInformation;
        this.ladder = new Ladder(ladderSize);
    }

    public LadderGameResult getResult() {
        Map<String, String> result = new LinkedHashMap<>();
        for (int index = 0; index < ladderGameInformation.getParticipants().size(); index++) {
            result.put(
                    ladderGameInformation.getParticipants().get(index),
                    ladderGameInformation.getResults().get(ladder.getResult(index))
            );
        }
        return new LadderGameResult(result, ladder);
    }
}
