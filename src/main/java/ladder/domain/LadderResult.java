package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private static final String KEY_ERROR = "참여자를 잘못 입력했습니다.";
    private static final int DEFAULT_INDEX = 0;
    private final Map<String, String> results;

    private LadderResult(Map results) {
        this.results = results;
    }

    public static LadderResult of(Person person, Winning winning, Ladder ladder) {
        Map<String, String> result = new HashMap<>();
        int[] lineIndex = {DEFAULT_INDEX};
        person.readOnlyPerson().stream()
                .forEach(index -> {
                    result.put(index, ladderResult(lineIndex[DEFAULT_INDEX]++, winning, ladder));
                });
        
        return new LadderResult(result);
    }

    private static String ladderResult(int nameIndex, Winning winning, Ladder ladder) {
        int[] lineIndex = { nameIndex };
        ladder.readOnlyLines().stream()
                .forEach(line -> lineIndex[DEFAULT_INDEX] = line.lineMoving(lineIndex[DEFAULT_INDEX]));

        return winning.readOnlyWinning().get(lineIndex[DEFAULT_INDEX]);
    }

    public String resultOfLadder(String name) {
        if (!results.containsKey(name)) {
            throw new IllegalArgumentException(KEY_ERROR);
        }
        return results.get(name);
    }

    public Map readOnlyResults() {
        return Collections.unmodifiableMap(results);
    }
}
