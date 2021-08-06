package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private String[] gameResults;

    public GameResult(String[] gameResults) {
        this.gameResults = gameResults;
    }

    public String showResult(int index) {
        return this.gameResults[index / 2];
    }


}
