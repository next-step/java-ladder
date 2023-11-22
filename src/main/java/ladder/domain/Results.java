package ladder.domain;

import java.util.*;

public class Results {

    private final Map<Position, Result> resultMap = new TreeMap<>((p1, p2) -> p1.position() - p2.position());

    public Results(List<String> results) {
        for (int i = 0; i < results.size(); i++) {
            Position position = new Position(i);
            Result result = new Result(results.get(i));

            resultMap.put(position, result);
        }
    }

    public List<Result> results() {
        return Collections.unmodifiableList(new ArrayList<>(this.resultMap.values()));
    }

    public Result find(Position position) {
        return this.resultMap.get(position);
    }

}
