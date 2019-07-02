package com.jaeyeonling.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    public static final String SEPARATOR = "\\s*,\\s*";

    private final List<LadderResult> results;

    private LadderResults(final List<LadderResult> results) {
        this.results = new ArrayList<>(results);
    }

    public static LadderResults ofSeparator(final String rawResults) {
        return Arrays.stream(rawResults.split(SEPARATOR))
                .map(LadderResult::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LadderResults::new));
    }

    public LadderResult findByIndex(final int index) {
        return results.get(index);
    }

    public List<LadderResult> getResults() {
        return Collections.unmodifiableList(results);
    }

    public int size() {
        return results.size();
    }
}
