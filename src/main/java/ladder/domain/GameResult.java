package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private String[] gameResults;
    private static final int TWO = 2;

    public GameResult(String[] gameResults) {
        this.gameResults = gameResults;
    }

    public String show(int index) {
        return this.gameResults[index / TWO];
    }

    public Map allResults(Users users) {
        Map resultMap = new HashMap<String, String>();
        for (User user : users) {
            String result = this.show(user.position());
            resultMap.put(user.name(), result);
        }
        return resultMap;
    }
}
