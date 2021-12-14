package ladder.model.gameresult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResults {

    private static final String RESULT_OF_ALL = "ALL";
    private final String resultOf;
    private final List<GameResult> gameResults = new ArrayList<>();

    public GameResults(String resultOf) {
        this.resultOf = resultOf;
    }

    public boolean isAll() { return this.resultOf.equalsIgnoreCase(RESULT_OF_ALL); }

    public void add(String name, int resultIndex) {
        gameResults.add(new GameResult(name, resultIndex));
    }

    public List<GameResult> get() {
        return Collections.unmodifiableList(gameResults);
    }
}
