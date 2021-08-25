package ladder.domain.ladder;

import ladder.exception.LadderMinimumHeightException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Ladder TEST")
class LadderTest {

    DirectionStrategy directionStrategy;

    @BeforeEach
    void setUp() {
        directionStrategy = () -> true;
    }

    @Test
    @DisplayName("Ladder 생성 후 사이즈 체크")
    void generateLadder_sizeCheck() {
        Ladder ladder = new Ladder(directionStrategy, 4, 5);

        List<Line> lines = ladder.getLines();
        int actual = lines.size();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리 높이가 낮을 때 Exception 발생")
    void ladderMinimumHeightException() {
        assertThatThrownBy(() -> new Ladder(directionStrategy, Ladder.MIN_HEIGHT - 1, 5))
                .isInstanceOf(LadderMinimumHeightException.class);
    }

    static Stream<Arguments> provideLadder() {
        DirectionStrategy directionStrategy = () -> true;
        return Stream.of(
                Arguments.of(new Ladder(directionStrategy, 3, 3), 0, 1),
                Arguments.of(new Ladder(directionStrategy, 3, 3), 1, 0),
                Arguments.of(new Ladder(directionStrategy, 3, 3), 2, 2),
                Arguments.of(new Ladder(directionStrategy, 2, 4), 0, 0),
                Arguments.of(new Ladder(directionStrategy, 2, 4), 1, 1),
                Arguments.of(new Ladder(directionStrategy, 2, 4), 2, 2),
                Arguments.of(new Ladder(directionStrategy, 2, 4), 3, 3)
        );
    }

    @ParameterizedTest(name = "startPoint: {1}, endPoint: {2}")
    @MethodSource("provideLadder")
    @DisplayName("사다리 실행")
    void ladderRun(Ladder ladder, int startPoint, int endPoint) {
        // given
        // when
        int actual = ladder.run(startPoint);

        // then
        assertThat(actual).isEqualTo(endPoint);
    }
}