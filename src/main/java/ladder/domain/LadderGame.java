package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Players players;
    private final Results results;

    public LadderGame(Players players, Results results) {
        this.players = players;
        this.results = results;
    }
    
    public Ladder makeLadder(int height, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generator(players.getCountOfPlayer()));
        }
        return Ladder.of(lines);
    }

    public LadderResult start(Ladder ladder) {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < players.getCountOfPlayer(); i++) {
            ladderResult.put(players.getPlayer(i), results.getResult(ladder.move(i)));
        }
        return ladderResult;
    }
}
