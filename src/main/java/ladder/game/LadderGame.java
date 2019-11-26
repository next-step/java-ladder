package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.ConnectionStrategy;

import java.util.*;

public class LadderGame {
    private final Ladder ladder;
    private final GameInfo gameInfo;

    public LadderGame(String inputParticipant, int ladderHeight, ConnectionStrategy connection, String inputResults) {
        this.gameInfo = new GameInfo(inputParticipant, inputResults);
        this.ladder = new Ladder(gameInfo.getParticipantsSize(), ladderHeight, connection);
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

    public Results getResult(String... input) {
        Participants participants = gameInfo.getParticipants();
        Prizes prizes = gameInfo.getPrizes();

        List<String> users = Arrays.asList(input);

        if (users.size() == 0) {
            users = participants.getNames();
        }

        Map<String, String> results = new HashMap<>();
        List<Integer> finalPoints = ladder.getFinalPoints().getPoints();

        for (String user : users) {
            int index = participants.indexOf(user);
            int finalPoint = finalPoints.get(index);
            results.put(user, prizes.getPrize(finalPoint));
        }
        return new Results(Collections.unmodifiableMap(results));
    }
}
