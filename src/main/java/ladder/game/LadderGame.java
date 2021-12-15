package ladder.game;

import ladder.model.gameresult.GameResults;
import ladder.model.ladder.Ladder;
import ladder.model.player.Players;

public class LadderGame {

    private static final String RESULT_OF_ALL = "ALL";
    private final Ladder ladder;
    private final Players players;

    public LadderGame(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public GameResults play(String resultOf) {
        checkValidation(resultOf);
        GameResults gameResult = new GameResults(resultOf);
        players.getResultOf(resultOf).forEach(
            player -> gameResult.add(player.name(), ladder.move(players.indexOf(player)))
        );
        return gameResult;
    }

    private void checkValidation(String resultOf) {
        if(!resultOf.equalsIgnoreCase(RESULT_OF_ALL) && !players.contains(resultOf)) {
            throw new IllegalArgumentException("해당 이름을 가진 참가자가 없습니다.");
        }
    }
}
