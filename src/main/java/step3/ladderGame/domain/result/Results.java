package step3.ladderGame.domain.result;

import step3.ladderGame.domain.exception.DifferentCountOfPlayerAndResultException;
import step3.ladderGame.domain.exception.NotFoundIndexException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class Results {

    private final List<Result> results;

    public Results(final List<String> resultNames, final int playerCount) {
        validate(resultNames.size(), playerCount);
        AtomicInteger index = new AtomicInteger();

        results = resultNames.stream()
                .map(result -> new Result(result, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

    private void validate(final int resultCount, final int playerCount) {
        if (resultCount != playerCount) {
            throw new DifferentCountOfPlayerAndResultException();
        }
    }

    public String findResult(final int index) {
        return results.stream()
                .filter(result -> index == result.getIndex())
                .findFirst()
                .map(Result::getResult)
                .orElseThrow(NotFoundIndexException::new);
    }

}
