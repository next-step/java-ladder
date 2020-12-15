package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LadderGame {

    private final String NOT_EXISTS_NAME = "Not exists name";
    private final LadderGameInformation ladderGameInformation;
    private final Ladder ladder;

    public LadderGame(LadderGameInformation ladderGameInformation, Ladder ladder) {
        this.ladderGameInformation = ladderGameInformation;
        this.ladder = ladder;
    }

    public LadderGameResult getLadderGameResult() {
        Map<String, String> result = new TreeMap<>();

        List<Integer> indexes = ladder.run();

        for (int index = 0; index < ladderGameInformation.getParticipants().size(); index++) {
            result.put(ladderGameInformation.getParticipants().get(index),
                    ladderGameInformation.getResults().get(indexes.get(index)));
        }

        return new LadderGameResult(result, ladder);
    }

}
