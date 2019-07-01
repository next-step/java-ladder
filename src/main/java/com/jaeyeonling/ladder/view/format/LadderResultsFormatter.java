package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.ladder.LadderResults;
import com.jaeyeonling.ladder.domain.user.Username;

import java.util.stream.Collectors;

public class LadderResultsFormatter implements Formatter<LadderResults> {

    private static final String FORMAT = String.format("%s%d%s", "%", Username.MAX_LENGTH, "s");

    private static final String PREFIX = " ";
    private static final String BLANK = " ";

    @Override
    public String format(final LadderResults ladderResults) {
        return PREFIX + ladderResults.getResults()
                .stream()
                .map(result -> String.format(FORMAT, result))
                .collect(Collectors.joining(BLANK));
    }
}
