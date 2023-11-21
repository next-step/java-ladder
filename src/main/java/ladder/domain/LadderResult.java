package ladder.domain;

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
            int position = position(ladder, nameIdx);
            Result result = results.of(position);

            ladderResult.put(name, result);
        }

        return ladderResult;
    }

    private int position(Ladder ladder, int startPosition) {
        int position = startPosition;
        for (Row row : ladder.rows()) {
            position = moved(position, row);
        }
        return position;
    }

    private int moved(int position, Row row) {
        if (canForward(position, row)) {
            return position + 1;
        }

        if (canBackward(position, row)) {
            return position - 1;
        }

        return position;
    }

    private Boolean canForward(int position, Row row) {
        return !row.isBoundary(position) && row.available(position);
    }

    private Boolean canBackward(int position, Row row) {
        int backwardPosition = position - 1;

        return !row.isBoundary(backwardPosition) && row.available(backwardPosition);
    }

    public Map<Name, Result> result() {
        return this.resultMap;
    }

    public Result of(Name name) {
        return this.resultMap.get(name);
    }

}
