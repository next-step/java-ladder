package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderResult {

    private final Map<Name, Result> resultMap;

    public LadderResult(Names names, Ladder ladder, Results results) {
        this.resultMap = result(names, ladder, results);
    }

    private Map<Name, Result> result(Names names, Ladder ladder, Results results) {
        Map<Name, Result> ladderResult = new HashMap<>();
        for (int nameIdx = 0; nameIdx < names.size(); nameIdx++) {
            Name name = names.of(nameIdx);
            Position position = position(ladder, nameIdx);
            Result result = results.find(position);

            ladderResult.put(name, result);
        }

        return ladderResult;
    }

    private Position position(Ladder ladder, int startPosition) {
        Position position = new Position(startPosition);
        for (Row row : ladder.rows()) {
            position = position.moved(row);
        }
        return position;
    }

    public Map<Name, Result> result() {
        return Collections.unmodifiableMap(this.resultMap);
    }

    public Result of(Name name) {
        return this.resultMap.get(name);
    }

}
