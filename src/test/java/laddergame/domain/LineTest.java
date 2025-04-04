package laddergame.domain;

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
}
