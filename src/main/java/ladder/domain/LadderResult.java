package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LadderResult {
    private static final String EVERY_PLAYER = "all";

    private final List<ResultElement> resultElements;

    public LadderResult() {
        this(Arrays.asList());
    }

    public LadderResult(ResultElement resultElement) {
        this(Arrays.asList(resultElement));
    }

    public LadderResult(List<ResultElement> resultElements) {
        this.resultElements = resultElements;
    }

    public List<ResultElement> elements() {
        return Collections.unmodifiableList(resultElements);
    }

    public LadderResult result(String playerName) {
        if (playerName.equals(EVERY_PLAYER)) {
            return this;
        }

        List<ResultElement> filteredResultElements = resultElements.stream()
                .filter(resultElement -> resultElement.nameEquals(playerName))
                .collect(Collectors.toList());
        return new LadderResult(filteredResultElements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(resultElements, that.resultElements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultElements);
    }
}
