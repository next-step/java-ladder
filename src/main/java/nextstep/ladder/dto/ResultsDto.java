package nextstep.ladder.dto;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Results;

public class ResultsDto {
    private final List<String> values;

    public ResultsDto(List<String> values) {
        this.values = values;
    }

    public ResultsDto(List<Integer> resultPosition, Results results) {
        this(convertToResults(resultPosition, results));
    }

    private static List<String> convertToResults(List<Integer> resultPosition, Results results) {
        return resultPosition.stream()
                .map(index -> results.getValues().get(index))
                .collect(Collectors.toList());
    }

    public List<String> getValues() {
        return values;
    }
}
