package ladder.game;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<String, String> prizeByParticipant;

    Result() {
        this.prizeByParticipant = new HashMap<>();
    }

    public void put(String user, String prize) {
        prizeByParticipant.put(user, prize);
    }

    public Map<String, String> getPrizeByParticipant() {
        return prizeByParticipant;
    }
}
