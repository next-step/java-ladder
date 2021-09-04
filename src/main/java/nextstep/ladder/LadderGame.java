package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private Players players;
    private Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public Result start(Result result) {
        List<String> gameResult = new ArrayList<>();
        for (int i=0; i< players.size(); i++) {
            int index = ladder.move(i);
            gameResult.add(result.get(index));
        }
        return new Result(gameResult);
    }
}
