package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResult {

    private final Map<HorizontalPosition, String> resultMap = new HashMap<>();

    public LadderResult(List<String> result, int userNumber) throws IllegalArgumentException {
        if (result.size() != userNumber) {
            throw new IllegalArgumentException("게임 결과 개수가 사용자 개수와 다릅니다.");
        }
        result.stream().forEach(this::validate);
        IntStream.range(0, result.size())
                .forEach((idx) -> this.resultMap.put(new HorizontalPosition(idx), result.get(idx)));
    }

    public String result(HorizontalPosition position) {
        return this.resultMap.get(position);
    }

    private void validate(String result) {
        if (result == null || result.isBlank()) {
            throw new IllegalArgumentException("게임 결과가 비어있습니다.");
        }
    }

    public List<String> getResult() {
        return this.resultMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public int size() {
        return this.resultMap.keySet().size();
    }

}
