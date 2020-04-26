package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    private List<ResultValue> results;

    private LadderResult(List<ResultValue> results) {
        this.results = results;
    }

    public static LadderResult getInstance(String[] results) {
        return new LadderResult(Arrays.stream(results)
                .map(ResultValue::getInstance)
                .collect(Collectors.toList())
        );
    }

    public static LadderResult getNewInstance(LadderResult ladderResult) {
        return new LadderResult(ladderResult.results.stream()
                .map(ResultValue::getNewInstance)
                .collect(Collectors.toList()));
    }

    public List<String> getValues() {
        return results.stream()
                .map(ResultValue::valueOf)
                .collect(Collectors.toList());
    }

    public int getWidth() {
        return results.size();
    }
}
