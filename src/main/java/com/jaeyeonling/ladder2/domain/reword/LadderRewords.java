package com.jaeyeonling.ladder2.domain.reword;

import com.jaeyeonling.ladder2.view.StringVisualizable;
import com.jaeyeonling.ladder2.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRewords implements StringVisualizable {

    private static final String BLANK = " ";

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
                .map(reword -> StringUtils.rightAlign(reword, LadderReword.MAX_LENGTH))
                .collect(Collectors.joining(BLANK));
    }
}
