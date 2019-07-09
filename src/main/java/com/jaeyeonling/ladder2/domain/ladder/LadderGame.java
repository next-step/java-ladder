package com.jaeyeonling.ladder2.domain.ladder;

import com.jaeyeonling.ladder2.domain.Index;
import com.jaeyeonling.ladder2.domain.line.DirectionGenerateStrategy;
import com.jaeyeonling.ladder2.domain.line.Line;
import com.jaeyeonling.ladder2.domain.line.Lines;
import com.jaeyeonling.ladder2.domain.line.RandomDirectionGenerateStrategy;
import com.jaeyeonling.ladder2.domain.reword.LadderReword;
import com.jaeyeonling.ladder2.domain.reword.LadderRewords;
import com.jaeyeonling.ladder2.domain.user.Username;
import com.jaeyeonling.ladder2.domain.user.Users;
import com.jaeyeonling.ladder2.view.StringVisualizable;

import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class LadderGame implements StringVisualizable {

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

    public LadderGameResult play() {
        final Map<Username, LadderReword> ladderGameResult = gameInfo.range()
                .boxed()
                .map(Index::valueOf)
                .collect(toMap(gameInfo::findUsernameBy, this::rideAndFindLadderRewordBy));

        return LadderGameResult.of(ladderGameResult);
    }

    @Override
    public String visualize() {
        return String.format(gameInfo.visualize(), lines.visualize());
    }

    private LadderReword rideAndFindLadderRewordBy(final Index index) {
        return gameInfo.findLadderRewordBy(lines.ride(index));
    }

    public static class Builder {
        private static final DirectionGenerateStrategy DEFAULT_DIRECTION_GENERATE_STRATEGY =
                new RandomDirectionGenerateStrategy();
        private static final HeightOfLadder DEFAULT_HEIGHT_OF_LADDER = HeightOfLadder.valueOf(10);

        private final Users users;
        private final LadderRewords ladderRewords;

        private DirectionGenerateStrategy directionGenerateStrategy;
        private HeightOfLadder heightOfLadder;

        private Builder(final Users users,
                        final LadderRewords ladderRewords) {
            this.users = users;
            this.ladderRewords = ladderRewords;
        }

        public LadderGame build() {
            return new LadderGame(generateGameInfo(), generateLines());
        }

        public Builder directionGenerateStrategy(final DirectionGenerateStrategy directionGenerateStrategy) {
            this.directionGenerateStrategy = directionGenerateStrategy;
            return this;
        }

        public Builder heightOfLadder(final HeightOfLadder heightOfLadder) {
            this.heightOfLadder = heightOfLadder;
            return this;
        }

        private GameInfo generateGameInfo() {
            return GameInfo.with(users, ladderRewords);
        }

        private Lines generateLines() {
            return getHeightOfLadder().rangeClosed()
                    .mapToObj(ignore -> generateLine())
                    .collect(collectingAndThen(toList(), Lines::of));
        }

        private Line generateLine() {
            return Line.generate(getDirectionGenerateStrategy(), users);
        }

        private HeightOfLadder getHeightOfLadder() {
            return Optional.ofNullable(heightOfLadder)
                    .orElse(DEFAULT_HEIGHT_OF_LADDER);
        }

        private DirectionGenerateStrategy getDirectionGenerateStrategy() {
            return Optional.ofNullable(directionGenerateStrategy)
                    .orElse(DEFAULT_DIRECTION_GENERATE_STRATEGY);
        }
    }
}
