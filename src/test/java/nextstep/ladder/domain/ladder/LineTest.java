package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("점으로 이루어진 선을 생성할 수 있다.")
    @Test
    void line() {
        assertDoesNotThrow(() -> {
            new Line(List.of(new Point(1, true),
                    new Point(2, false),
                    new Point(3, true)));
        });
    }

    @DisplayName("사용자 수 만큼의 점들로 이루어진 선이 생성된다.")
    @Test
    void lineCountOfPlayer() {
        Line line = Line.create(5, () -> true);

        assertThat(line.points()).hasSize(5);
    }

    @DisplayName("활성화된 점이 연속적으로 연결된 경우 예외가 발생한다.")
    @Test
    void lineException() {
        assertThatThrownBy(() -> {
            new Line(List.of(new Point(1, true),
                    new Point(2, true),
                    new Point(3, true),
                    new Point(4, true),
                    new Point(5, true)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("점이 2개 미만인 경우 예외가 발생한다.")
    @Test
    void lineSizeException() {
        assertThatThrownBy(() -> {
            new Line(List.of(new Point(1, true)));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}