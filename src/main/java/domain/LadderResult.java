package domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {
    private static final String ALL = "all";
    private final Map<String, String> ladderResult;

    private LadderResult(Map<String, String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResult of(Map<String, String> ladderResult) {
        return new LadderResult(ladderResult);
    }

    public String getResult(String who) {
        if (ALL.equals(who)) {
            return ladderResult.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " : " + entry.getValue())
                    .collect(Collectors.joining("\n"));
        }

        if (!ladderResult.containsKey(who)) {
            throw new IllegalArgumentException();
        }

        return ladderResult.get(who);
    }
}
