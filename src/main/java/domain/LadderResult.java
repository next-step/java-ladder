package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderResult {
    List<String> ladderResult;
    Map<Position, String> resultMap;

    public LadderResult(List<String> ladderResult) {
        this.ladderResult = ladderResult;
        this.resultMap = new HashMap<>();

        IntStream.range(0, ladderResult.size())
                .forEach(i -> resultMap.put(new Position(i), ladderResult.get(i)));
    }

    public String result(Position position) {
        return resultMap.get(position);
    }
}
