package ladder.domain;

import ladder.pattern.CustomValueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static ladder.domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class LadderTest {
    @ParameterizedTest
    @DisplayName("전략 패턴을 이용하여 사다리를을 생성한다. (custom boolean")
    @MethodSource("booleanListProvider")
    void create_사다리_생성_전략패턴_custom(List<Boolean> booleanList, List<Line> lines) {
        CustomValueGenerator customValueGenerator = new CustomValueGenerator(booleanList);
        Ladder ladder = Ladder.create(5, 5, customValueGenerator);
        assertThat(ladder).isEqualTo(new Ladder(lines));
    }

    static Stream<Arguments> booleanListProvider() {
        return Stream.of(
                arguments(List.of(true, false, true, false,
                                false, true, false, true,
                                true, true, false, false,
                                false, false, false, true,
                                false, false, false, false),
                        List.of(
                                new Line(List.of(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, RIGHT), new Point(3, LEFT), new Point(4, STRAIGHT))),
                                new Line(List.of(new Point(0, STRAIGHT), new Point(1, RIGHT), new Point(2, LEFT), new Point(3, RIGHT), new Point(4, LEFT))),
                                new Line(List.of(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, STRAIGHT), new Point(3, STRAIGHT), new Point(4, STRAIGHT))),
                                new Line(List.of(new Point(0, STRAIGHT), new Point(1, STRAIGHT), new Point(2, STRAIGHT), new Point(3, RIGHT), new Point(4, LEFT))),
                                new Line(List.of(new Point(0, STRAIGHT), new Point(1, STRAIGHT), new Point(2, STRAIGHT), new Point(3, STRAIGHT), new Point(4, STRAIGHT)))
                        )
                )
        );
    }

    @Test
    @DisplayName("전략 패턴을 이용하여 사다리를 생성한다. (boolean all true)")
    void create_사다리_생성_boolean_all_true() {
        Ladder ladder = Ladder.create(3, 5, () -> true);
        Line line = new Line(List.of(new Point(0, Direction.RIGHT), new Point(1, Direction.LEFT), new Point(2, Direction.STRAIGHT)));
        List<Line> lines = List.of(line, line, line, line, line);
        assertThat(new Ladder(lines)).isEqualTo(ladder);
    }

    @Test
    @DisplayName("전략 패턴을 이용하여 사다리를 생성한다. (boolean all false)")
    void create_사다리_생성_boolean_all_false() {
        Ladder ladder = Ladder.create(3, 5, () -> false);
        Line line = new Line(List.of(new Point(0, Direction.STRAIGHT), new Point(1, Direction.STRAIGHT), new Point(2, Direction.STRAIGHT)));
        List<Line> lines = List.of(line, line, line, line, line);
        assertThat(new Ladder(lines)).isEqualTo(ladder);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("라인 리스트가 null 일 경우 예외가 발생한다.")
    void Ladder_라인_null(List<Line> lines) {
        assertThatThrownBy(() -> new Ladder(lines)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    @DisplayName("사다리 높이가 1 미만인 경우 예외가 발생한다.")
    void create_사다리_높이_1_미만(int height) {
        assertThatThrownBy(() -> Ladder.create(3, height, () -> true)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리 타기 게임 실행 후, 최종 위치의 포지션을 반환한다.")
    @CsvSource(value = {
            "0, 2",
            "1, 1",
            "2, 0"
    })
    void move_최종_포지션_반환(int startPosition, int finalPosition) {
        CustomValueGenerator customValueGenerator = new CustomValueGenerator(List.of(
                true, true,
                false, true,
                true, false));
        Ladder ladder = Ladder.create(3, 3, customValueGenerator);
        assertThat(ladder.finalPosition(startPosition)).isEqualTo(finalPosition);
    }
}