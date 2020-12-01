package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {

    @DisplayName("오른쪽에 발판이 존재하는지 알 수 있다")
    @Test
    void hasSpokeRightSide() {
        Line line = Spoke.of(true, false, true).toLine();
        assertAll(
                () -> assertThat(line.hasSpokeRightSide(Position.of(0))).isTrue(),
                () -> assertThat(line.hasSpokeRightSide(Position.of(1))).isFalse(),
                () -> assertThat(line.hasSpokeRightSide(Position.of(2))).isTrue()
        );
    }

    @DisplayName("|-----| 의 경우 입력 포지션과 출력 포지션이 다르다")
    @Test
    void moveWithLine() {
        Line line = Spoke.of(true).toLine();
        assertAll(
                () -> assertThat(line.moveOn(Position.of(0))).isEqualTo(Position.of(1)),
                () -> assertThat(line.moveOn(Position.of(1))).isEqualTo(Position.of(0))
        );
    }

    @DisplayName("라인 바깥쪽 포지션은 입력받을 수 없다")
    @Test
    void outOfLineEndException() {
        Line line = Spoke.of(true).toLine();
        assertThatThrownBy(() -> line.moveOn(Position.of(2)))
                .isInstanceOf(OutOfLineException.class);
    }


    @DisplayName("|-----|     | 의 경우 입력 포지션과 출력 포지션이 다르다")
    @Test
    void moveWithLineWithThreePole() {
        Line line = Spoke.of(true, false).toLine();
        assertAll(
                () -> assertThat(line.moveOn(Position.of(0))).isEqualTo(Position.of(1)),
                () -> assertThat(line.moveOn(Position.of(1))).isEqualTo(Position.of(0)),
                () -> assertThat(line.moveOn(Position.of(2))).isEqualTo(Position.of(2))
        );
    }
}
