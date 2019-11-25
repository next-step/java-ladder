package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.ConnectionStrategy;

import java.util.Arrays;
import java.util.List;

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

    public Result getResult(String... input) {
        Result result = new Result();
        Participants participants = gameInfo.getParticipants();
        Prizes prizes = gameInfo.getPrizes();

        List<String> users = Arrays.asList(input);

        if (users.size() == 0) {
            users = participants.getNames();
        }

        for (String user : users) {
            int index = participants.indexOf(user);
            int finalPoint = ladder.getFinalPoint(index);
            result.put(user, prizes.getPrize(finalPoint));
        }
        return result;
    }
}
