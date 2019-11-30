package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.MoveStrategy;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final GameInfo gameInfo;

    public LadderGame(String inputParticipant, int ladderHeight, MoveStrategy moveStrategy,
                      String inputResults) {
        this.gameInfo = new GameInfo(inputParticipant, inputResults);
        this.ladder = new Ladder(gameInfo.sizeOfParticipants(), ladderHeight, moveStrategy);
    }

    public Results getPrizesByParticipant() {
        Participants participants = gameInfo.getParticipants();

        List<String> users = participants.toStrings();
        List<Prize> prizeList = gameInfo.getPrizes().values();

        Map<String, String> results = new LinkedHashMap<>();
        List<Integer> finalPoints = ladder.getFinalPoints();
        for (String user : users) {
            int index = participants.indexOf(user);
            results.put(user, prizeList.get(finalPoints.get(index)).toString());
        }
        return new Results(Collections.unmodifiableMap(results));
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Participants getParticipants() {
        return gameInfo.getParticipants();
    }

    public Prizes getPrizes() {
        return gameInfo.getPrizes();
    }
}
