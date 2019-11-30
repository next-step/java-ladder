package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.MoveStrategy;
import ladder.structure.connection.result.Point;

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
        Prizes prizes = gameInfo.getPrizes();

        List<String> users = participants.toStrings();

        Map<String, String> results = new LinkedHashMap<>();
        List<Prize> prizeList = prizes.values();
        List<Point> finalPoints = ladder.getFinalPoints().getPoints();

        for (String user : users) {
            int index = participants.indexOf(user);
            int finalPoint = finalPoints.get(index).getColumn();
            results.put(user, prizeList.get(finalPoint).toString());
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
