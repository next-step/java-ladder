package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-19 13:39
 */
public class LadderResult {
    private final Map<String, String> ladderResult = new LinkedHashMap<>();

    public LadderResult(Ladder ladder, List<String> names, List<String> executeResult) {
        createResult(ladder, names, executeResult);
    }

    private void createResult(Ladder ladder, List<String> names, List<String> executeResult) {
        names.forEach(name -> {
            ladderResult.put(name, executeResult.get(ladder.play(names.indexOf(name))));
        });
    }

    public List<String> findResultByName(String input) {
        return ladderResult.entrySet()
                .stream()
                .filter(entry -> "all".equals(input) || entry.getKey().equals(input))
                .map(result -> String.format("%s : %s", result.getKey(), result.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResult);
    }
}
