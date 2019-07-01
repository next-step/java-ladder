package com.jaeyeonling.ladder.domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    static final String SEPARATOR = "\\s*,\\s*";

    private final List<String> results;

    private LadderResults(final List<String> results) {
        this.results = results;
    }

    public static LadderResults ofSeparator(final String rawResults) {
        final List<String> results = Arrays.stream(rawResults.split(SEPARATOR))
                .collect(Collectors.toList());

        return new LadderResults(results);
    }

    public String findByIndex(final int index) {
        return results.get(index);
    }

    int size() {
        return results.size();
    }
}
