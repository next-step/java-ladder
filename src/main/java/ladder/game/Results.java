package ladder.game;

import java.util.Collections;
import java.util.Map;

public class Results {
    private Map<String, String> prizeByParticipant;

    Results(Map<String, String> result) {
        this.prizeByParticipant = Collections.unmodifiableMap(result);
    }

    public Map<String, String> values() {
        return Collections.unmodifiableMap(prizeByParticipant);
    }
}
