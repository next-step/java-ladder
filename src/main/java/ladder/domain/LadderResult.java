package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderResult {

    private final Map<Position, Result> results = new HashMap<>();

    public LadderResult(List<String> result, int userNumber) throws IllegalArgumentException {
        if (result.size() != userNumber) {
            throw new IllegalArgumentException("게임 결과 개수가 사용자 개수와 다릅니다.");
        }
        IntStream.range(0, result.size())
                .forEach((idx) -> this.results.put(new Position(idx), new Result(result.get(idx))));
    }

    public LadderResult() {
    }

    public Result findResultByPosition(Position position) {
        return this.results.get(position);
    }

    public int size() {
        return this.results.size();
    }

    public void add(Position position ,Result result){
        results.put(position,result);
    }

}
