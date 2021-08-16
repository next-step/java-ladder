package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("한줄 선 true/false 그리기")
    void init() {
        Line line = Line.of(4);

        line.getPoints().forEach(point -> {
            System.out.print(point.isLeft() + " ");
        });

        assertThat(line.getPoints().get(0).isLeft()).isEqualTo(false);
        assertThat(line.getPoints().size()).isEqualTo(4);
    }
}