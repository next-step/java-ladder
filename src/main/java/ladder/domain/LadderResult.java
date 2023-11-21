package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {

    private final Map<Name, Result> resultMap;

    public LadderResult(Names names, Ladder ladder, Results results) {
        this.resultMap = result(names, ladder, results);
    }

    private Map<Name, Result> result(Names names, Ladder ladder, Results results) {
        Map<Name, Result> ladderResult = new HashMap<>();
        for (int nameIdx = 0; nameIdx < names.size(); nameIdx++) {
            Name name = names.name(nameIdx);
            int position = position(ladder, nameIdx);
            Result result = results.result(position);

            ladderResult.put(name, result);
        }

        return ladderResult;
    }

    private int position(Ladder ladder, int startPosition) {
        int position = startPosition;
        for (Row row : ladder.rows()) {
            position = moved(position, row.cols());
        }
        return position;
    }

    private int moved(int position, List<Boolean> cols) {
        if (canForward(position, cols)) {
            return position + 1;
        }

        if (canBackward(position, cols)) {
            return position - 1;
        }

        return position;
    }

    private Boolean canForward(int position, List<Boolean> cols) {
        return position != cols.size() && cols.get(position);
    }

    private Boolean canBackward(int position, List<Boolean> cols) {
        int backwardPosition = position - 1;

        return backwardPosition >= 0 && cols.get(backwardPosition);
    }

    public Map<Name, Result> result() {
        return this.resultMap;
    }

    public Result of(Name name) {
        return this.resultMap.get(name);
    }

}
