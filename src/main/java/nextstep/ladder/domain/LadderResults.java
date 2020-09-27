package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LadderResults {

    private final Map<Lane, String> results;

    private LadderResults(List<String> results) {
        this.results = convertToMap(results);
    }

    public static LadderResults of(int countOfPersons, List<String> results) {
        validateCount(countOfPersons, results);
        return new LadderResults(results);
    }

    private static void validateCount(int countOfPersons, List<String> results) {
        if (countOfPersons != results.size()) {
            throw new IllegalArgumentException("결과 수가 사람 수와 일치하지 않습니다.");
        }
    }

    private Map<Lane, String> convertToMap(List<String> results) {
        Map<Lane, String> resultMap = new LinkedHashMap<>();
        IntStream.range(0, results.size())
                .forEach(i -> resultMap.put(Lane.of(i), results.get(i)));
        return resultMap;
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(new ArrayList<>(results.values()));
    }

    public String getResultByLane(Lane lane) {
        return results.get(lane);
    }
}
