package ladder.domain.line;

import ladder.domain.player.Players;
import ladder.domain.point.Point;
import ladder.domain.strategy.PointStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @DisplayName("LadderLine 객체 생성 테스트")
    @Test
    void createLadderLineTest() {
        Players players = Players.of("pobi,honux,crong,jk");
        PointStrategy pointStrategy = () -> false;

        LadderLine ladderLine = LadderLine.of(players.size(), pointStrategy);

        assertThat(ladderLine).isEqualTo(LadderLine.of(players.size(), pointStrategy));
    }

    @DisplayName("LadderLine > Point 생성 테스트")
    @ParameterizedTest
    @MethodSource("createLadderLine")
    void getPointsTest(LadderLine input, List<Point> expected) {
        assertThat(input.getPoints()).isEqualTo(expected);

    }

    private static Stream<Arguments> createLadderLine() {
        return Stream.of(
                Arguments.of(LadderLine.of(3, () -> false), Arrays.asList(Point.of(false), Point.of(false), Point.of(false)),
                Arguments.of(LadderLine.of(3, () -> true)), Arrays.asList(Point.of(false), Point.of(true), Point.of(false)))
        );
    }
}