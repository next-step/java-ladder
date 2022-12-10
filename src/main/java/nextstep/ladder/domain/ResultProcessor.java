package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultProcessor {
    private List<String> people;
    private List<String> result;

    public ResultProcessor(final List<String> people, final List<String> result) {
        this.people = people;
        this.result = result;
    }

    public LadderResults toResult(PlayResults results) {
        return new LadderResults(IntStream.range(0, people.size())
                .boxed()
                .collect(Collectors.toMap(i -> people.get(i), i -> result.get(results.getTarget(i)), (a, b) -> b)));
    }
}
