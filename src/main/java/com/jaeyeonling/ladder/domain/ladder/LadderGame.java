package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.GameInfo;
import com.jaeyeonling.ladder.domain.GameResult;
import com.jaeyeonling.ladder.domain.line.HeightOfLadder;
import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.line.LinesFactory;
import com.jaeyeonling.ladder.domain.point.Point;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.exception.NotInitializeLineException;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderGame {

    private static final int START_LINE = 0;

    private final GameInfo gameInfo;
    private Lines lines;

    private LadderGame(final GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    public static LadderGame of(final GameInfo gameInfo) {
        return new LadderGame(gameInfo);
    }

    public Lines getLines() {
        return lines;
    }

    public Users getUsers() {
        return gameInfo.getUsers();
    }

    public LadderRewords getRewords() {
        return gameInfo.getRewords();
    }

    public void initializeLines(final HeightOfLadder heightOfLadder,
                                final LinesFactory linesFactory) {
        this.lines = linesFactory.create(gameInfo, heightOfLadder);
    }

    public GameResult play() {
        if (!isInitialize()) {
            throw new NotInitializeLineException();
        }

        final Map<String, LadderReword> rewordOfUsername = gameInfo.userStream()
                .map(User::getUsername)
                .map(Username::getUsername)
                .collect(Collectors.toMap(Function.identity(), this::findMatchingReword));

        return GameResult.of(rewordOfUsername);
    }

    private boolean isInitialize() {
        return Objects.nonNull(lines);
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
