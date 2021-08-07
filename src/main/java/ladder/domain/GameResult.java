package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private String[] gameResults;

    public GameResult(String[] gameResults) {
        this.gameResults = gameResults;
    }

    public String showResult(int index) {
        return this.gameResults[index / 2];
    }

    public Map allResults(Users users) {
        Map resultMap = new HashMap<String, String>();

        for (User user : users) {
            String result = this.showResult(user.position());
            resultMap.put(user.name(), result);

        }

        return resultMap;
    }


}
