package ladder.domain.expert;

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

    int size() {
        return results.size();
    }

    public ResultDto exportResultDto(int position) {
        return results.get(position)
                .exportResultDto();
    }

    public ResultsDto exportResultsDto() {
        return results.stream()
                .map(Result::exportResultDto)
                .collect(collectingAndThen(toList(), ResultsDto::new));
    }

    public ResultsDto exportMovedResultsDto(Function<Integer, Integer> move) {
        return IntStream.range(0, size())
                .boxed()
                .map(move)
                .map(this::exportResultDto)
                .collect(collectingAndThen(toList(), ResultsDto::new));
    }
}
