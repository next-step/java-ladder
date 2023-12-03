package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public Results(String... results) {
        this.results = Arrays.stream(results)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public String result(int index){
        return results.get(index).result();
    }

    public int resultSize() {
        return this.results.size();
    }
}
