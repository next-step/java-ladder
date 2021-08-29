package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Results {

    private static final String DELIMITER = ",";

    private final List<Result> results;

    public Results(final String names) {
        results = Arrays.stream(names.split(DELIMITER))
                .map(Result::new)
                .collect(toList());
    }

    public List<String> getResultNames() {
        return results.stream()
                .map(Result::getName)
                .collect(toList());
    }

    public String getName(final int position) {
        return results.get(position)
                .getName();
    }

}
