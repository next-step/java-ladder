package nextstep.ladder.domain;

import nextstep.ladder.exception.ResultSizeMismatchException;

import java.util.*;

public class Results {

    private static final String NAMES_DELIMITER = ",";

    private final List<Result> results = new ArrayList<>();

    public Results(String result) {
        Arrays.stream(result.split(NAMES_DELIMITER))
                .forEach(name -> this.results.add(new Result(name)));
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
            Name name = names.get(nameIdx);
            int position = ladder.move(nameIdx);
            result.put(name, get(position));
        }
        return new LadderResult(result);
    }
}
