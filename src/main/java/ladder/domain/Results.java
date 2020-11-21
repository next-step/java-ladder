package ladder.domain;

import ladder.dto.ResultDto;
import ladder.dto.ResultsDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

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

    public ResultDto exportResult(int position) {
        return results.get(position)
                .exportResultDto();
    }

    public ResultsDto exportResultsDto() {
        return results.stream()
                .map(Result::exportResultDto)
                .collect(collectingAndThen(toList(), ResultsDto::new));
    }

    public ResultsDto exportMovedResultsDto(Function<Integer, Integer> move) {
        return IntStream.range(0, getSize())
                .boxed()
                .map(move)
                .map(this::exportResult)
                .collect(collectingAndThen(toList(), ResultsDto::new));
    }
}
