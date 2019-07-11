package com.jaeyeonling.ladder.domain.reword;

import com.jaeyeonling.ladder.utils.StringUtils;
import com.jaeyeonling.ladder.view.StringVisualizable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderRewords implements StringVisualizable {

    public static final String SEPARATOR = "\\s*,\\s*";

    private static final String BLANK = " ";

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

    @Override
    public String visualize() {
        return BLANK + ladderRewords.stream()
                .map(LadderReword::visualize)
                .map(this::align)
                .collect(Collectors.joining(BLANK));
    }

    private String align(final String reword) {
        return StringUtils.rightAlign(reword, LadderReword.MAX_LENGTH);
    }
}
