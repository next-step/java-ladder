package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.ConnectionStrategy;

import java.util.*;

public class LadderGame {
    private final Ladder ladder;
    private final GameInfo gameInfo;

    public LadderGame(String inputParticipant, int ladderHeight, ConnectionStrategy connection, String inputResults) {
        this.gameInfo = new GameInfo(inputParticipant, inputResults);
        this.ladder = new Ladder(gameInfo.sizeOfParticipants(), ladderHeight, connection);
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

    public Results checkResults(String... input) {
        Participants participants = gameInfo.getParticipants();
        Prizes prizes = gameInfo.getPrizes();

        List<String> users = Arrays.asList(input);

        if (users.size() == 0) {
            users = participants.toStrings();
        }

        Map<String, String> results = new HashMap<>();
        Points finalPoints = ladder.getFinalPoints();
        List<Prize> prizeList = prizes.values();

        for (String user : users) {
            int index = participants.indexOf(user);
            int finalPoint = finalPoints.get(index).value();
            results.put(user, prizeList.get(finalPoint).toString());
        }
        return new Results(Collections.unmodifiableMap(results));
    }
}
