package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @DisplayName("사다리 행 생성 테스트")
    @Test
    void create_line() {
        assertThat(new Line(3, () -> true).getLine())
                .containsExactly(new Point(false), new Point(true), new Point(false));
    }

    @DisplayName("사다리 한 행 진행 테스트")
    @Test
    void down_one_line() {
        Line line = new Line(3, () -> true);
        assertThat(line.down(0)).isEqualTo(1);
    }
}
