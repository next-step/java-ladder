package ladder.domain.result;

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

}
