package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Results {

    private static final int MINIMUM_COUNT = 2;

    private final List<Result> results;

    private Results(List<Result> results) {
        Assert.notEmpty(results, "results must not be empty");
        validateSize(results);
        this.results = new ArrayList<>(results);
    }

    public static Results from(StringsProvider provider) {
        Assert.notNull(provider, "provider must not be blank");
        return new Results(provider.strings()
                .stream()
                .map(Result::from)
                .collect(Collectors.toList())
        );
    }

    public List<Result> list() {
        return Collections.unmodifiableList(results);
    }

    public boolean hasDifferentSize(int size) {
        return results.size() != size;
    }

    private void validateSize(List<Result> results) {
        if (results.size() < MINIMUM_COUNT) {
            throw new IllegalArgumentException(String.format("results count(%d) must be at least %d", results.size(), MINIMUM_COUNT));
        }
    }

    @Override
    public String toString() {
        return "Results{" +
                "results=" + results +
                '}';
    }
}
