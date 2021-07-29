package nextstep.ladder.domain.result;

import nextstep.ladder.domain.ladder.LadderPosition;
import nextstep.ladder.exception.NullArgumentException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    private Results(List<String> results) {
        validate(results);

        this.results = results.stream()
                .map(Result::from)
                .collect(Collectors.toList());
    }

    private void validate(List<String> results) {
        if (Objects.isNull(results)) {
            throw new NullArgumentException("Results");
        }
    }

    public static Results init(List<String> results) {
        return new Results(results);
    }

    public List<String> getResults() {
        return results.stream()
                .map(Result::getResult)
                .collect(Collectors.toList());
    }

    public String getResultAt(LadderPosition endPosition) {
        return results.get(endPosition.toInt())
                .getResult();
    }
}
