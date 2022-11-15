package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results
{
    private final List<Result> results;

    private Results(List<Result> results)
    {
        this.results = results;
    }

    public static Results of(String[] resultArray, int userSize) {
        if (userSize != resultArray.length) {
            throw new IllegalArgumentException("결과값과 인원수가 다릅니다");
        }
        return new Results(Arrays.stream(resultArray)
            .map(Result::from)
            .collect(Collectors.toList())
        );
    }

    public List<Result> getResults() {
        return results;
    }
}
