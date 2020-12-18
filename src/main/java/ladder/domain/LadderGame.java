package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final LadderGameInformation ladderGameInformation;
    private final Ladder ladder;

    public LadderGame(LadderGameInformation ladderGameInformation, Ladder ladder) {
        this.ladderGameInformation = ladderGameInformation;
        this.ladder = ladder;
    }

    public LadderGameResult getLadderGameResult(LadderResult ladderResult) {
        Map<String, String> result = new LinkedHashMap<>();
        for (int index = 0; index < ladderGameInformation.getParticipants().size(); index++) {
            result.put(
                    ladderGameInformation.getParticipants().get(index),
                    ladderGameInformation.getResults().get(ladderResult.get(index))
            );
        }
        ladder.printLadder();
        return new LadderGameResult(result, ladder);
    }

}
