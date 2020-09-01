package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("입력한 위치에 제대로 Line이 그려지는지 테스트")
    public void draw_line_test() {

        // given
        int points = 5;
        Line line = Line.valueOf(points);

        // when
        line.draw(0);

        // then
        assertThat(line.hasLine(0)).isTrue();
    }

}
