package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.GameResult;
import com.jaeyeonling.ladder.domain.ladder.LadderReword;

import java.util.stream.Collectors;

public class GameResultFormatter implements Formatter<GameResult> {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String MATCHING_RESULT_FORMAT = "%s : %s";

    private final Formatter<LadderReword> ladderRewordFormatter;

    private GameResultFormatter(final Formatter<LadderReword> ladderRewordFormatter) {
        this.ladderRewordFormatter = ladderRewordFormatter;
    }

    public static GameResultFormatter withLadderRewordFormatter(final Formatter<LadderReword> ladderRewordFormatter) {
        return new GameResultFormatter(ladderRewordFormatter);
    }

    @Override
    public String format(final GameResult gameResult) {
        return gameResult.stream()
                .map(rewordOfUsername -> {
                    final String username = rewordOfUsername.getKey();
                    final LadderReword ladderReword = rewordOfUsername.getValue();

                    final String formattedMatchingReword = ladderRewordFormatter.format(ladderReword);
                    return String.format(MATCHING_RESULT_FORMAT, username, formattedMatchingReword);
                })
                .collect(Collectors.joining(NEW_LINE));
    }
}
