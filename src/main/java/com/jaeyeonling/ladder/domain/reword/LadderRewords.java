package com.jaeyeonling.ladder.domain.reword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderRewords {

    public static final String SEPARATOR = "\\s*,\\s*";

    private final List<LadderReword> ladderRewords;

    private LadderRewords(final List<LadderReword> ladderRewords) {
        this.ladderRewords = new ArrayList<>(ladderRewords);
    }

    public static LadderRewords ofSeparator(final String rawLadderRewords) {
        return Arrays.stream(rawLadderRewords.split(SEPARATOR))
                .map(LadderReword::valueOf)
                .collect(collectingAndThen(toList(), LadderRewords::new));
    }

    public int size() {
        return ladderRewords.size();
    }

    public LadderReword findLadderRewordBy(final int index) {
        return ladderRewords.get(index);
    }

    public Stream<LadderReword> stream() {
        return ladderRewords.stream();
    }
}
