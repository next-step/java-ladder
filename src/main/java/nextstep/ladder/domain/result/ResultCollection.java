package nextstep.ladder.domain.result;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultCollection {
    private final List<Result> results;

    public ResultCollection(List<Result> results) {
        this.results = results;
    }

    public static ResultCollection of(List<String> resultString) {
        List<Result> results = resultString.stream()
                .map(Result::new)
                .collect(Collectors.toList());
        return new ResultCollection(results);
    }

    public List<Result> getUsers() {
        return Collections.unmodifiableList(results);
    }

    public Result getResultFromIndex(int index){
        return results.get(index);
    }

    public int size(){
        return results.size();
    }
}
