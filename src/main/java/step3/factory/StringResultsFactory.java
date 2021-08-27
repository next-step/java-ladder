package step3.factory;

import step3.Position;
import step3.Result;
import step3.Results;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringResultsFactory implements ResultsFactory {
    private final List<String> resultStrings;

    public StringResultsFactory(List<String> resultStrings) {
        this.resultStrings = resultStrings;
    }

    @Override
    public Results createResults() {
        List<Result> results = IntStream.range(0, resultStrings.size())
                .mapToObj(i -> new Result(resultStrings.get(i), new Position(i)))
                .collect(Collectors.toList());

        return new Results(results);
    }
}
