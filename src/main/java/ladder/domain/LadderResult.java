package ladder.domain;

import ladder.domain.ResultElement;

import java.util.*;
import java.util.stream.Collectors;


public class LadderResult {
    private static final String EVERY_PLAYER = "all";

    private final List<ResultElement> results;

    public LadderResult() {
        this(Arrays.asList());
    }

    public LadderResult(ResultElement resultElement) {
        this(Arrays.asList(resultElement));
    }

    public LadderResult(List<ResultElement> resultElements) {
        this.results = new ArrayList<>();
        this.results.addAll(resultElements);
    }

    public void add(ResultElement resultElement) {
        results.add(resultElement);
    }

    public List<ResultElement> result(String playerName) {
        if (playerName.equals(EVERY_PLAYER)) {
            return results;
        }

        List<ResultElement> result = results.stream()
                .filter(resultElement -> resultElement.nameEquals(playerName))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(result);
    }
}
