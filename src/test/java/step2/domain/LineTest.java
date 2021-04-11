package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("사람인원수 만큼 라인이 그려졌는지 테스트")
    void lineSizeTest() {
        Line line = new Line(3, new FixedGenerator(true));
        assertThat(line.getLineSize()).isEqualTo(3);
    }
}