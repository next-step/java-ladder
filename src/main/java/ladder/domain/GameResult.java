package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<String> gameResults;

    public GameResult(List<String> gameResults){
        this.gameResults = gameResults;
    }

    public String showResult(int index){
        return this.gameResults.get(index);
    }


}
