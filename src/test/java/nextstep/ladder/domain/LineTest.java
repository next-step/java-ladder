package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {

    @DisplayName("|-----| 의 경우 입력 포지션과 출력 포지션이 다르다")
    @Test
    void moveWithLine() {
        Line line = toLines(Spoke.of(true));
        assertAll(
                () -> assertThat(line.moveOn(Position.of(0))).isEqualTo(Position.of(1)),
                () -> assertThat(line.moveOn(Position.of(1))).isEqualTo(Position.of(0))
        );
    }

    @DisplayName("라인 바깥쪽 포지션은 입력받을 수 없다")
    @Test
    void outOfLineEndException() {
        Line line = toLines(Spoke.of(true));
        assertThatThrownBy(() -> line.moveOn(Position.of(2)))
                .isInstanceOf(OutOfLineException.class);
    }

    @DisplayName("|-----|     | 의 경우 입력 포지션과 출력 포지션이 다르다")
    @Test
    void moveWithLineWithThreePole() {
        Line line = toLines(Spoke.of(true, false));
        assertAll(
                () -> assertThat(line.moveOn(Position.of(0))).isEqualTo(Position.of(1)),
                () -> assertThat(line.moveOn(Position.of(1))).isEqualTo(Position.of(0)),
                () -> assertThat(line.moveOn(Position.of(2))).isEqualTo(Position.of(2))
        );
    }

    @DisplayName("|     |-----| 의 경우 입력 포지션과 출력 포지션이 다르다")
    @Test
    void moveWithLineWithThreePoleOther() {
        Line line = toLines(Spoke.of(false, true));
        assertAll(
                () -> assertThat(line.moveOn(Position.of(0))).isEqualTo(Position.of(0)),
                () -> assertThat(line.moveOn(Position.of(1))).isEqualTo(Position.of(2)),
                () -> assertThat(line.moveOn(Position.of(2))).isEqualTo(Position.of(1))
        );
    }

    @DisplayName("|-----|" +
                 "|-----| 의 경우 입력 포지션과 출력 포지션이 같다")
    @Test
    void moveWithTwoLineTwoStairs() {
        Line line = toLines(Spoke.of(true), Spoke.of(true));

        assertAll(
                () -> assertThat(line.moveOn(Position.of(0))).isEqualTo(Position.of(0)),
                () -> assertThat(line.moveOn(Position.of(1))).isEqualTo(Position.of(1))
        );
    }

    @DisplayName("|-----|     |" +
                 "|     |-----| 의 경우 입력 포지션과 출력 포지션이 하나씩 교차된다")
    @Test
    void moveWithThreeLineTwoStairs() {
        Line line = toLines(Spoke.of(true, false), Spoke.of(false, true));

        assertAll(
                () -> assertThat(line.moveOn(Position.of(0))).isEqualTo(Position.of(2)),
                () -> assertThat(line.moveOn(Position.of(1))).isEqualTo(Position.of(0)),
                () -> assertThat(line.moveOn(Position.of(2))).isEqualTo(Position.of(1))
        );
    }

    public static Lines toLines(Spoke... spokes) {
        return Lines.of(Stream.of(spokes));
    }

}
