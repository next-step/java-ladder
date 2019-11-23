package nextstep.ladder.domain.game;

import nextstep.ladder.domain.game.GameResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResults {

    private final List<GameResult> gameResults = new ArrayList<>();

    public void add(GameResult result) {
        gameResults.add(result);
    }

    public List<GameResult> getValue() {
        return Collections.unmodifiableList(gameResults);
    }
}
