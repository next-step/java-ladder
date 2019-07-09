package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.ladder.LadderReword;
import com.jaeyeonling.ladder.domain.ladder.LadderRewords;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.utils.StringUtils;

import java.util.stream.Collectors;

public class LadderRewordsFormatter implements Formatter<LadderRewords> {

    private static final String PREFIX = " ";
    private static final String BLANK = " ";

    private final Formatter<LadderReword> ladderRewordFormatter;

    private LadderRewordsFormatter(final Formatter<LadderReword> ladderRewordFormatter) {
        this.ladderRewordFormatter = ladderRewordFormatter;
    }

    public static LadderRewordsFormatter withLadderRewordFormatter(final Formatter<LadderReword> ladderRewordFormatter) {
        return new LadderRewordsFormatter(ladderRewordFormatter);
    }

    @Override
    public String format(final LadderRewords ladderRewords) {
        return PREFIX + ladderRewords.getLadderRewords()
                .stream()
                .map(ladderRewordFormatter::format)
                .map(reword -> StringUtils.rightAlign(reword, Username.MAX_LENGTH))
                .collect(Collectors.joining(BLANK));
    }
}
