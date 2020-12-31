package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Results {
    private List<Result> results = new ArrayList<>();

    public Results(String results) {

        final int[] index = {0};
        Arrays.stream(results.split(","))
                .map(String::trim)
                .forEach(result -> this.results.add(new Result(index[0]++, result)));

    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }


}
