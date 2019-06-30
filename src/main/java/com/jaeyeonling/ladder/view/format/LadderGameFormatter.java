package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.user.Users;

public class LadderGameFormatter implements Formatter<LadderGame> {

    private static final String FORMAT = "%s\n%s";

    private final Formatter<Users> usersFormatter;
    private final Formatter<Lines> linesFormatter;

    private LadderGameFormatter(final Formatter<Users> usersFormatter,
                                final Formatter<Lines> linesFormatter) {
        this.usersFormatter = usersFormatter;
        this.linesFormatter = linesFormatter;
    }

    public static LadderGameFormatter withUsersFormatterAndLinesFormatter(final Formatter<Users> usersFormatter,
                                                                          final Formatter<Lines> linesFormatter) {
        return new LadderGameFormatter(usersFormatter, linesFormatter);
    }

    @Override
    public String format(final LadderGame ladderGame) {
        final String formattedUsers = usersFormatter.format(ladderGame.getUsers());
        final String formattedLines = linesFormatter.format(ladderGame.getLines());

        return String.format(FORMAT, formattedUsers, formattedLines);
    }
}
