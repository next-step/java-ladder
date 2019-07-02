package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.exception.EmptyLadderResultException;
import com.jaeyeonling.ladder.exception.LongerThanMaxLengthLadderResultException;
import com.jaeyeonling.ladder.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {

    private static final Map<String, LadderResult> CACHE = new HashMap<>();

    public static final int MAX_LENGTH = 5;

    private final String ladderResult;

    private LadderResult(final String ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResult valueOf(final String ladderResult) {
        if (StringUtils.isNullOrEmpty(ladderResult)) {
            throw new EmptyLadderResultException();
        }
        if (StringUtils.isOverLength(ladderResult, MAX_LENGTH)) {
            throw new LongerThanMaxLengthLadderResultException(ladderResult);
        }

        return CACHE.computeIfAbsent(ladderResult, LadderResult::new);
    }

    public String getLadderResult() {
        return this.ladderResult;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LadderResult)) {
            return false;
        }

        final LadderResult that = (LadderResult) o;
        return Objects.equals(this.getLadderResult(), that.getLadderResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ladderResult);
    }
}
