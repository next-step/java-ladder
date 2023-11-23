package nextstep.step4.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {
    private final Map<String, String> results;

    public LadderResult(final Map<String, String> results) {
        this.results = results;
    }

    public String get(final String name) {
        if ("all".equals(name)) {
            return buildAllResult();
        }

        return results.getOrDefault(name, "존재하지 않는 이름입니다.");
    }

    private String buildAllResult() {
        return results.entrySet().stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}
