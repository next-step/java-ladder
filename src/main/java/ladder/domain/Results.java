package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Results {
    private final List<String> result;

    public Results(final int countOfPerson, final List<String> result) {
        if (result == null || result.size() < 1 || result.size() != countOfPerson) {
            throw new IllegalArgumentException("The number of results must be greater than 1 and equal to the number of users. countOfPerson="+countOfPerson+", result="+result.size());
        }
        this.result = result;
    }

    public Results(final List<String> result) {
        this.result = result;
    }

    public List<String> getAll() {
        return Collections.unmodifiableList(result);
    }

    public String get(final int index) {
        return result.get(index);
    }
}
