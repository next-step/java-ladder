package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.exception.EmptyLadderRewordException;
import com.jaeyeonling.ladder.exception.LongerThanMaxLengthLadderRewordException;
import com.jaeyeonling.ladder.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderReword {

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

    public String getLadderReword() {
        return this.ladderReword;
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
        return Objects.equals(this.getLadderReword(), that.getLadderReword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ladderReword);
    }
}
