package com.jaeyeonling.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRewords {

    public static final String SEPARATOR = "\\s*,\\s*";

    private final List<LadderReword> ladderRewords;

    private LadderRewords(final List<LadderReword> ladderRewords) {
        this.ladderRewords = new ArrayList<>(ladderRewords);
    }

    public static LadderRewords ofSeparator(final String rawLadderRewords) {
        return Arrays.stream(rawLadderRewords.split(SEPARATOR))
                .map(LadderReword::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LadderRewords::new));
    }

    public LadderReword findByIndex(final int index) {
        return ladderRewords.get(index);
    }

    public List<LadderReword> getLadderRewords() {
        return Collections.unmodifiableList(ladderRewords);
    }

    public int size() {
        return ladderRewords.size();
    }
}
