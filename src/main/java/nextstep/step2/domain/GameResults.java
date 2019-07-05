package nextstep.step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResults {
    private final List<Result> results;

    public GameResults(List<Result> results) {
        this.results = results;
    }

    public static GameResults create(List<String> gameResults) {
        final int size = gameResults.size();
        return new GameResults(IntStream.range(0, size)
                                        .mapToObj(i -> new Result(i, gameResults.get(i)))
                                        .collect(Collectors.toList()));
    }

    public Result findByPosition(final int position) {
        validatePosition(position);

        return this.results.stream()
                           .filter(result -> result.equalsPosition(position))
                           .findFirst()
                           .orElse(new Result(position, "꽝"));
    }

    private void validatePosition(final int position) {
        if (position >= results.size() || position < 0) {
            throw new IndexOutOfBoundsException("position 범위가 잘 못 입력되었습니다.");
        }
    }
}
