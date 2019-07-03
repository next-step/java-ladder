package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.GameInfo;
import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.point.Point;
import com.jaeyeonling.ladder.domain.user.User;

import java.util.stream.Stream;

public class LadderGame {

    private static final int START_LINE = 0;
    static final String FINISH_CHARACTER = "all";

    private final GameInfo gameInfo;
    private final Lines lines;

    private LadderGame(final GameInfo gameInfo,
                       final Lines lines) {
        this.gameInfo = gameInfo;
        this.lines = lines;
    }

    public static LadderGame of(final GameInfo gameInfo,
                                final Lines lines) {
        return new LadderGame(gameInfo, lines);
    }

    public Lines getLines() {
        return lines;
    }

    public boolean isShowAll(final String usernameOfWantReword) {
        return FINISH_CHARACTER.equalsIgnoreCase(usernameOfWantReword);
    }

    public Stream<User> userStream() {
        return gameInfo.userStream();
    }

    public LadderReword findMatchingReword(final String usernameOfMatchReword) {
        final int indexOfLadder = gameInfo.findUserIndexByUsername(usernameOfMatchReword);
        final int indexOfReword = ride(indexOfLadder);

        return gameInfo.findLadderRewordByIndex(indexOfReword);
    }

    private int ride(final int indexOfLadder) {
        final Point point = Point.of(indexOfLadder, START_LINE);
        final Point resultPoint = lines.ride(point);

        return resultPoint.getIndexOfLadder();
    }
}
