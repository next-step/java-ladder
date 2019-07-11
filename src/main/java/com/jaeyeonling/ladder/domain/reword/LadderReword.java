package com.jaeyeonling.ladder.domain.reword;

import com.jaeyeonling.ladder.exception.EmptyLadderRewordException;
import com.jaeyeonling.ladder.exception.LongerThanMaxLengthLadderRewordException;
import com.jaeyeonling.ladder.utils.StringUtils;
import com.jaeyeonling.ladder.view.StringVisualizable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderReword implements StringVisualizable {

    private static final Map<String, LadderReword> CACHE = new HashMap<>();

    public static final int MAX_LENGTH = 5;

    private final String ladderReword;

    private LadderReword(final String ladderReword) {
        this.ladderReword = ladderReword;
    }

    public static LadderReword valueOf(final String ladderReword) {
        if (StringUtils.isNullOrEmpty(ladderReword)) {
            throw new EmptyLadderRewordException();
        }
        if (StringUtils.isOverLength(ladderReword, MAX_LENGTH)) {
            throw new LongerThanMaxLengthLadderRewordException(ladderReword);
        }

        return CACHE.computeIfAbsent(ladderReword, LadderReword::new);
    }

    @Override
    public String visualize() {
        return ladderReword;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LadderReword)) {
            return false;
        }

        final LadderReword that = (LadderReword) o;
        return Objects.equals(ladderReword, that.ladderReword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderReword);
    }
}
