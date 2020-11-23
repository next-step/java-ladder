package ladder.domain;

import ladder.exception.BadResultsException;

import java.util.List;

public class ValidatedResults extends Results {

    public ValidatedResults(int sizeOfPersons, List<Result> results) {
        super(results);
        if (sizeOfPersons != results.size()) {
            throw BadResultsException.getInstance();
        }
    }
}
