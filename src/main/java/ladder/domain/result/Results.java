package ladder.domain.result;

import ladder.exception.result.ResultNotExistException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Results {

    public final List<Result> results;

    public Results(String... strings) {
        this.results = Stream.of(strings)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<Result> results() {
        return Collections.unmodifiableList(results);
    }

    public Result result(int index) {
        if (results.size() < index) {
            throw new ResultNotExistException();
        }
        return results.get(index);
    }
}
