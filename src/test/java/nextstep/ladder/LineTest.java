package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("이전 좌표값에 선이 있을 경우 현재 좌표에는 선을 그리지 않는다.")
    @Test
    void line_create_line_or_not() {
        Line line = new Line();
        line.addLine(() -> false);
        line.addLine(() -> false);
        line.addLine(() -> true);
        line.addLine(() -> true);

        assertThat(line.getPointStatus(0)).isFalse();
        assertThat(line.getPointStatus(1)).isFalse();
        assertThat(line.getPointStatus(2)).isTrue();
        assertThat(line.getPointStatus(3)).isFalse();
    }
}