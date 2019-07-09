package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.GameInfo;
import com.jaeyeonling.ladder.domain.GameResult;
import com.jaeyeonling.ladder.domain.line.*;
import com.jaeyeonling.ladder.domain.point.Point;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderGame {

    private static final int START_LINE = 0;

    private final GameInfo gameInfo;
    private Lines lines;

    private LadderGame(final GameInfo gameInfo,
                       final Lines lines) {
        this.gameInfo = gameInfo;
        this.lines = lines;
    }

    public static Builder builder(final Users users,
                                  final LadderRewords ladderRewords) {
        return new Builder(users, ladderRewords);
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

    public static class Builder {
        private static final PointGenerateStrategy DEFAULT_POINT_GENERATE_STRATEGY = new RandomPointGenerateStrategy();
        private static final HeightOfLadder DEFAULT_HEIGHT_OF_LADDER = HeightOfLadder.valueOf(10);

        private final Users users;
        private final LadderRewords ladderRewords;

        private PointGenerateStrategy pointGenerateStrategy;
        private LineGenerator lineGenerator;
        private LinesFactory linesFactory;
        private HeightOfLadder heightOfLadder;

        private Builder(final Users users,
                        final LadderRewords ladderRewords) {
            this.users = users;
            this.ladderRewords = ladderRewords;
        }

        public LadderGame build() {
            final GameInfo gameInfo = GameInfo.withUsersAndLadderRewords(users, ladderRewords);
            final Lines lines = getLinesFactory().create(gameInfo, getHeightOfLadder());

            return new LadderGame(gameInfo, lines);
        }

        public Builder pointGenerateStrategy(final PointGenerateStrategy pointGenerateStrategy) {
            this.pointGenerateStrategy = pointGenerateStrategy;
            return this;
        }

        public Builder lineGenerator(final LineGenerator lineGenerator) {
            this.lineGenerator = lineGenerator;
            return this;
        }

        public Builder linesFactory(final LinesFactory linesFactory) {
            this.linesFactory = linesFactory;
            return this;
        }

        public Builder heightOfLadder(final HeightOfLadder heightOfLadder) {
            this.heightOfLadder = heightOfLadder;
            return this;
        }

        private LinesFactory getLinesFactory() {
            return Optional.ofNullable(linesFactory)
                    .orElseGet(() -> GeneratorBaseLinesFactory.withLineGenerator(getLineGenerator()));
        }

        private LineGenerator getLineGenerator() {
            return Optional.ofNullable(lineGenerator)
                    .orElseGet(() -> StrategyBaseLineGenerator.withStrategy(getPointGenerateStrategy()));
        }

        private PointGenerateStrategy getPointGenerateStrategy() {
            return Optional.ofNullable(pointGenerateStrategy)
                    .orElse(DEFAULT_POINT_GENERATE_STRATEGY);
        }

        private HeightOfLadder getHeightOfLadder() {
            return Optional.ofNullable(heightOfLadder)
                    .orElse(DEFAULT_HEIGHT_OF_LADDER);
        }
    }
}
