package nextstep.ladder.domain;

import nextstep.ladder.exception.ResultSizeMismatchException;

import java.util.*;

import static nextstep.ladder.util.StringSplit.stringSplitToList;

public class Results {

    private final List<Result> results = new ArrayList<>();

    public Results(String result) {
        Arrays.stream(stringSplitToList(result))
                .forEach(value -> this.results.add(new Result(value)));
    }

    public void validateSize(int size) {
        if (results.size() != size) {
            throw new ResultSizeMismatchException();
        }
    }

    public List<Result> values() {
        return results;
    }

    public Result get(int i) {
        return results.get(i);
    }

    public LadderResult of(Names names, Ladder ladder) {
        Map<Name, Result> result = new HashMap<>();
        for (int nameIdx = 0; nameIdx < names.size(); nameIdx++) {
            result.put(names.get(nameIdx), get(ladder.move(nameIdx)));
        }
        return new LadderResult(result);
    }
}
