package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public Results playLadder(Players players, Winnings winnings) {
        List<Result> results = new ArrayList<>();
        Iterator<Player> playerIterator = players.iterator();
        while(playerIterator.hasNext()) {
            Player player = playerIterator.next();
            int playResult = player.playLadder(this.ladder);
            results.add(new Result(player.toString().trim(), winnings.valueOf(playResult).toString()));
        }

        return new Results(results);
    }
}
