package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


class LadderTest {
    @Test
    void create_사다리가_생성된다__전략_패턴_랜덤_boolean_true_인_경우() {
        Ladder ladder = Ladder.create(3, 5, () -> true);
        Line line = new Line(List.of(new Point(0, Direction.RIGHT), new Point(1, Direction.LEFT), new Point(2, Direction.STRAIGHT)));
        List<Line> lines = List.of(line, line, line, line, line);
        assertThat(new Ladder(lines)).isEqualTo(ladder);
    }

    @Test
    void create_사다리가_생성된다__전략_패턴_랜덤_boolean_false_인_경우() {
        Ladder ladder = Ladder.create(3, 5, () -> false);
        Line line = new Line(List.of(new Point(0, Direction.STRAIGHT), new Point(1, Direction.STRAIGHT), new Point(2, Direction.STRAIGHT)));
        List<Line> lines = List.of(line, line, line, line, line);
        assertThat(new Ladder(lines)).isEqualTo(ladder);
    }

    @ParameterizedTest
    @NullSource
    void Ladder_라인들이_null_인_경우(List<Line> lines) {
        assertThatThrownBy(() -> new Ladder(lines)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    void create_사다리높이_1_미만인_경우(int height) {
        assertThatThrownBy(() -> Ladder.create(3, height, () -> true)).isInstanceOf(IllegalArgumentException.class);
    }
}