package nextstep.step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResults {
    private List<Result> results;

    public GameResults(List<Result> results) {
        this.results = results;
    }

    public static GameResults create(List<String> gameResults) {
        return new GameResults(gameResults.stream()
                                          .map(Result::new)
                                          .collect(Collectors.toList()));
    }
}
