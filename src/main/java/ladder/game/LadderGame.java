package ladder.game;

import ladder.model.gameresult.GameResults;
import ladder.model.ladder.Ladder;
import ladder.model.player.Players;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;

    public LadderGame(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public GameResults play(String resultOf) {
        GameResults gameResult = new GameResults(resultOf);
        players.getResultOf(resultOf).forEach(
            player -> gameResult.add(player.name(), ladder.move(players.indexOf(player)))
        );
        return gameResult;
    }
}
