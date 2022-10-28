package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Results {

    public static List<Result> results;

    public Results(String... strings) {
        this.results = Stream.of(strings)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<Result> results() {
        return Collections.unmodifiableList(results);
    }

}
