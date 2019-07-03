package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.GameInfo;
import com.jaeyeonling.ladder.domain.GameResult;
import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.point.Point;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderGame {

    private static final int START_LINE = 0;

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

    public GameResult play() {
        final Map<String, LadderReword> rewordOfUsername = gameInfo.userStream()
                .map(User::getUsername)
                .map(Username::getUsername)
                .collect(Collectors.toMap(Function.identity(), this::findMatchingReword));

        return GameResult.of(rewordOfUsername);
    }

    LadderReword findMatchingReword(final String usernameOfMatchReword) {
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
