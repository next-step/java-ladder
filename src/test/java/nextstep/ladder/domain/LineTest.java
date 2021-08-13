package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("한줄 선 true/false 그리기")
    void init() {
        Line line = Line.of(4);
        line.getPoints().forEach(point -> {
            System.out.print(point.isLeft() + " ");
        });
        assertThat(line.getPoints().size()).isEqualTo(4);
    }
}