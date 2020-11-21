package ladder.domain;

import ladder.dto.ResultsDto;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Results {
    private final List<Result> results;

    Results(List<Result> results) {
        this.results = results;
    }

    public int getSize() {
        return results.size();
    }

    public ResultsDto getResultsDto() {
        return results.stream()
                .map(Result::getResultDto)
                .collect(collectingAndThen(toList(), ResultsDto::new));
    }
}
