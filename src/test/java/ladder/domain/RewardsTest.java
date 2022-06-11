package ladder.domain;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.exception.NeedMoreResultValueException;
import ladder.exception.NotEqualResultValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RewardsTest {

    @ParameterizedTest
    @CsvSource(value = {"꽝,5000,꽝,3000:3", "100,2000,5000:1"}, delimiter = ':')
    @DisplayName("게임 결과의 수와 플레이어의 수가 다르면 예외를 던진다.")
    public void NotEqualExceptionTest(String values, int playerNum) {
        Assertions.assertThrowsExactly(NotEqualResultValueException.class, () ->
                {
                    new Rewards(values, playerNum);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "꽝"})
    @DisplayName("게임 결과가 1개 이상이 아니면 예외를 던진다.")
    public void numExceptionTest(String values) {
        Assertions.assertThrowsExactly(NeedMoreResultValueException.class, () ->
                {
                    new Rewards(values);
                }
        );
    }

    /*
    테스트 사다리 그림

        1     2     3     4
        |-----|     |     |
        |     |-----|     |
      1000    꽝    꽝    꽝

     */
    private static Stream<Arguments> RewardsTestArgs() {
        return Stream.of(
                arguments(
                        new Rewards("1000,꽝,꽝,꽝", 4),
                        new Ladder(List.of(
                                new Line(
                                        List.of(new Point(0, new Direction(false,true)), new Point(1, new Direction(true,false)),new Point(2, new Direction(false,false)),new Point(3, new Direction(false,false)))),
                                new Line(
                                        List.of(new Point(0, new Direction(false,false)), new Point(1, new Direction(false,true)),new Point(2, new Direction(true,false)),new Point(3, new Direction(false,false)))))),
                        0,
                        "꽝"
                ),
                arguments(
                        new Rewards("1000,꽝,꽝,꽝", 4),
                        new Ladder(List.of(
                                new Line(
                                        List.of(new Point(0, new Direction(false,true)), new Point(1, new Direction(true,false)),new Point(2, new Direction(false,false)),new Point(3, new Direction(false,false)))),
                                new Line(
                                        List.of(new Point(0, new Direction(false,false)), new Point(1, new Direction(false,true)),new Point(2, new Direction(true,false)),new Point(3, new Direction(false,false)))))),
                        1,
                        "1000"
                ),
                arguments(
                        new Rewards("1000,꽝,꽝,꽝", 4),
                        new Ladder(List.of(
                                new Line(
                                        List.of(new Point(0, new Direction(false,true)), new Point(1, new Direction(true,false)),new Point(2, new Direction(false,false)),new Point(3, new Direction(false,false)))),
                                new Line(
                                        List.of(new Point(0, new Direction(false,false)), new Point(1, new Direction(false,true)),new Point(2, new Direction(true,false)),new Point(3, new Direction(false,false)))))),
                        2,
                        "꽝"
                ),
                arguments(
                        new Rewards("1000,꽝,꽝,꽝", 4),
                        new Ladder(List.of(
                                new Line(
                                        List.of(new Point(0, new Direction(false,true)), new Point(1, new Direction(true,false)),new Point(2, new Direction(false,false)),new Point(3, new Direction(false,false)))),
                                new Line(
                                        List.of(new Point(0, new Direction(false,false)), new Point(1, new Direction(false,true)),new Point(2, new Direction(true,false)),new Point(3, new Direction(false,false)))))),
                        3,
                        "꽝"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("RewardsTestArgs")
    @DisplayName("사다리 게임의 결과 테스트")
    public void RewardsTest(Rewards rewards, Ladder ladder, int playerPos, String reward) {
        int rewardIdx = rewards.searchPlayerReward(ladder, playerPos);
        assertThat(rewards.findRewardName(rewardIdx)).isEqualTo(reward);
    }
}