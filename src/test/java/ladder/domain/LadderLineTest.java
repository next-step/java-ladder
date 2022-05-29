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

class LadderLineTest {
    @ParameterizedTest
    @DisplayName("전략 패턴을 이용하여 라인을 생성한다. (custom boolean")
    @MethodSource("booleanListProvider")
    void create_라인_생성_전략패턴_custom(List<Boolean> booleanList, List<Point> pointList) {
        CustomValueGenerator customValueGenerator = new CustomValueGenerator(booleanList);
        LadderLine ladderLine = LadderLine.create(5, customValueGenerator);
        assertThat(ladderLine).isEqualTo(new LadderLine(pointList));
    }

    static Stream<Arguments> booleanListProvider() {
        return Stream.of(
                arguments(List.of(true, false, true, false),
                        List.of(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, RIGHT), new Point(3, LEFT), new Point(4, STRAIGHT))),
                arguments(List.of(false, true, false, true),
                        List.of(new Point(0, STRAIGHT), new Point(1, RIGHT), new Point(2, LEFT), new Point(3, RIGHT), new Point(4, LEFT))),
                arguments(List.of(true, true, false, false),
                        List.of(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, STRAIGHT), new Point(3, STRAIGHT), new Point(4, STRAIGHT))),
                arguments(List.of(false, false, false, true),
                        List.of(new Point(0, STRAIGHT), new Point(1, STRAIGHT), new Point(2, STRAIGHT), new Point(3, RIGHT), new Point(4, LEFT))),
                arguments(List.of(false, false, false, false),
                        List.of(new Point(0, STRAIGHT), new Point(1, STRAIGHT), new Point(2, STRAIGHT), new Point(3, STRAIGHT), new Point(4, STRAIGHT)))
        );
    }

    @Test
    @DisplayName("전략 패턴을 이용하여 라인을 생성한다. (boolean all true)")
    void create_라인_생성_전략패턴_all_true() {
        LadderLine ladderLine = new LadderLine(List.of(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, STRAIGHT)));
        assertThat(LadderLine.create(3, () -> true)).isEqualTo(ladderLine);
    }

    @Test
    @DisplayName("전략 패턴을 이용하여 라인을 생성한다. (boolean all false)")
    void create_라인_생성_전략패턴_all_false() {
        LadderLine ladderLine = new LadderLine(List.of(new Point(0, STRAIGHT), new Point(1, STRAIGHT), new Point(2, STRAIGHT)));
        assertThat(LadderLine.create(3, () -> false)).isEqualTo(ladderLine);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("라인의 포인트 리스트가 null 인 경우 예외가 발생한다.")
    void LadderLine_포인트_null(List<Point> points) {
        assertThatThrownBy(() -> new LadderLine(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라인의 폭이 2 미만인 경우 예외가 발생한다. (생성자 이용)")
    void LadderLine_라인_폭_2미만() {
        List<Point> points = List.of(new Point(0, RIGHT));
        assertThatThrownBy(() -> new LadderLine(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1})
    @DisplayName("라인의 폭이 2 미만인 경우 예외가 발생한다. (정적 팩터리 메서드 이용)")
    void create_라인_폭_2미만(int width) {
        assertThatThrownBy(() -> LadderLine.create(width, () -> true)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라인의 첫번째 포인트 방향이 왼쪽인 경우 예외가 발생한다.")
    void LadderLine_첫번째_포인트_방향_왼쪽() {
        List<Point> points = List.of(new Point(0, LEFT), new Point(1, STRAIGHT));
        assertThatThrownBy(() -> new LadderLine(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라인의 첫번째 포인트 위치가 0이 아닌 경우 예외가 발생한다.")
    void LadderLine_첫번째_포인트_위치_0_아님() {
        List<Point> points = List.of(new Point(1, STRAIGHT), new Point(1, STRAIGHT));
        assertThatThrownBy(() -> new LadderLine(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "LEFT, LEFT",
            "STRAIGHT, LEFT",
            "RIGHT, STRAIGHT",
            "RIGHT, RIGHT"
    })
    @DisplayName("중간 포인트와 이전 포인트의 방향이 충돌나는 경우 예외가 발생한다.")
    void LadderLine_중간_포인트_방향_충돌(Direction previousDirection, Direction currentDirection) {
        List<Point> points = List.of(new Point(1, previousDirection), new Point(2, currentDirection), new Point(3, STRAIGHT));
        assertThatThrownBy(() -> new LadderLine(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("인접한 중간 포인트와 이전 포인트의 위치 차이가 1이 아닌 경우 예외가 발생한다.")
    void LadderLine_인접한_중간_포인트_위치_차이_1_아님() {
        List<Point> points = List.of(new Point(1, STRAIGHT), new Point(3, STRAIGHT), new Point(5, STRAIGHT));
        assertThatThrownBy(() -> new LadderLine(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 포인트의 방향이 오른쪽인 경우 예외가 발생한다.")
    void LadderLine_마지막_포인트_방향_오른쪽() {
        List<Point> points = List.of(new Point(0, STRAIGHT), new Point(1, RIGHT));
        assertThatThrownBy(() -> new LadderLine(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 포인트의 위치가 '최대 폭 - 1'이 아닌 경우 예외가 발생한다.")
    void LadderLine_마지막_포인트_위치_최대_폭_아님() {
        List<Point> points = List.of(new Point(0, STRAIGHT), new Point(1, STRAIGHT), new Point(3, STRAIGHT));
        assertThatThrownBy(() -> new LadderLine(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("현재 포인트에서 오른쪽으로 이동한다.")
    void LadderLine_오른쪽_이동() {
        LadderLine ladderLine = new LadderLine(List.of(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, STRAIGHT)));
        assertThat(ladderLine.move(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("현재 포인트에서 왼쪽으로 이동한다.")
    void LadderLine_왼쪽_이동() {
        LadderLine ladderLine = new LadderLine(List.of(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, STRAIGHT)));
        assertThat(ladderLine.move(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("현재 포인트에서 직진한다.")
    void LadderLine_직진() {
        LadderLine ladderLine = new LadderLine(List.of(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, STRAIGHT)));
        assertThat(ladderLine.move(2)).isEqualTo(2);
    }
}