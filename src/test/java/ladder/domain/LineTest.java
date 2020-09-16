package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private Line line;

    @DisplayName("생성한 라인 size가 올바른지 테스트")
    @Test
    void line_Size_Test() {
        line = new Line(5, () -> false);
        assertThat(line.size()).isEqualTo(5);
    }

    @DisplayName("Line 생성(False) 테스트")
    @Test
    void line_Generate_Test() {
        line = new Line(5, () -> false);
        assertThat(line.getIndex(2).isRight()).isFalse();
    }
}