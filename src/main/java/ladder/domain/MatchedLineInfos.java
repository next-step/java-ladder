package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchedLineInfos {
    private final Map<Integer, Integer> matchedLineInfos;

    public MatchedLineInfos(Map<Integer, Integer> matchedLineInfos) {
        this.matchedLineInfos = new HashMap<>(matchedLineInfos);
    }

    public int getMatchedLineNo(int lineNo) {
        return matchedLineInfos.get(lineNo);
    }
}
