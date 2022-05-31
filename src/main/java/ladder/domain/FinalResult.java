package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FinalResult {
    private final Map<String, String> finalResult;

    private FinalResult(List<String> results, List<String> names) {
        Map<String, String> temporary = new LinkedHashMap<>();
        for (int i = 0; i < names.size(); i++) {
            temporary.put(names.get(i), results.get(i));
        }

        this.finalResult = new LinkedHashMap<>(temporary);
    }

    public static FinalResult of(List<String> results, List<String> names) {
        return new FinalResult(results, names);
    }

    public Map<String, String> getFinalResult() {
        return finalResult;
    }
}
