package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Result {
    private final List<String> result;

    public Result(final int countOfPerson, final List<String> result) {
        if (result == null || result.size() < 1 || result.size() != countOfPerson) {
            throw new IllegalArgumentException("The number of results must be greater than 1 and equal to the number of users.");
        }
        this.result = result;
    }

    public List<String> getAll() {
        return Collections.unmodifiableList(result);
    }
}
