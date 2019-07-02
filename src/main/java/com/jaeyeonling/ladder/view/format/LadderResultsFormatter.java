package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.ladder.LadderResults;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.utils.StringUtils;

import java.util.stream.Collectors;

public class LadderResultsFormatter implements Formatter<LadderResults> {

    private static final String PREFIX = " ";
    private static final String BLANK = " ";

    @Override
    public String format(final LadderResults ladderResults) {
        return PREFIX + ladderResults.getResults()
                .stream()
                .map(result -> StringUtils.rightAlign(result, Username.MAX_LENGTH))
                .collect(Collectors.joining(BLANK));
    }
}
