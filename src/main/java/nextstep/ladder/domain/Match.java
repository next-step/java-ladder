package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Match {

    private final Ladder ladder;
    private Map<String, String> results = new HashMap<>();

    public Match(Ladder ladder) {
        this.ladder = ladder;
    }

    public int resultIdx(int input) {
        String[][] result = ladder.result();
        
        return 0;
    }

    public Map<String, String> value() {
        return results;
    }
}
