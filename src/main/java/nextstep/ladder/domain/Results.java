package nextstep.ladder.domain;

import nextstep.ladder.exception.ResultSizeMismatchException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Results {

    private static final String NAMES_DELIMITER = ",";

    private final List<Result> results = new ArrayList<>();

    public Results(String result) {
        Arrays.stream(result.split(NAMES_DELIMITER))
                .forEach(name -> this.results.add(new Result(name)));
    }

    public boolean validateSize(int size) {
        if (results.size() != size) {
            throw new ResultSizeMismatchException();
        }
        return true;
    }

    public List<Result> values() {
        return results;
    }

    public Result get(int i) {
        return results.get(i);
    }
}
