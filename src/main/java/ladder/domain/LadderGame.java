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
        for (int position = 0; position < ladderGameInformation.getParticipants().size(); position++) {
            result.put(
                    ladderGameInformation.getParticipants().get(position),
                    ladderGameInformation.getResults().get(ladder.getResultByPosition(position))
            );
        }
        return new LadderGameResult(result, ladder);
    }
}
