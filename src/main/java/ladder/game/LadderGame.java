package ladder.game;

import ladder.model.ladder.Height;
import ladder.model.ladder.Ladder;
import ladder.model.player.Players;
import ladder.model.result.Result;
import ladder.model.result.Results;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Results results;

    public LadderGame(Height height, Players players, Results results) {
        this.ladder = Ladder.create(height.get(), players.count());
        this.players = players;
        this.results = results;
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public Map<String,String> play() {
        Map<String,String> gameResult = new LinkedHashMap<String,String>();
        for(int startIndex = 0 ; startIndex < players.count() ; startIndex++) {
            Result result = results.get(ladder.move(startIndex));
            gameResult.put(players.name(startIndex), result.get());
        }
        return gameResult;
    }
}
