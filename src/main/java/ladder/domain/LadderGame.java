package ladder.domain;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGame {

    private Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    GameResult playLadder(LadderPlayers players, LadderResult result) {
        Map<Player, Result> results = new HashMap<>();

        IntStream.range(0, players.totalPlayerCount())
                .forEach(i -> results.put(players.findNthPlayer(i), result.findNthResult(this.ladder.moveLadder(i))));

        return new GameResult(results);
    }

}
