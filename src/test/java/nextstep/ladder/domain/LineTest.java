package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("한줄 선 true/false 그리기")
    void init() {
        Line line = Line.of(4, () -> true);

        line.getPoints().forEach(point -> {
            System.out.print(point.isLeft() + " ");
        });

        assertThat(line.getPoints().get(0).isLeft()).isEqualTo(false);
        assertThat(line.getPoints().get(1).isLeft()).isEqualTo(true);
        assertThat(line.getPoints().get(2).isLeft()).isEqualTo(false);
        assertThat(line.getPoints().get(3).isLeft()).isEqualTo(true);
    }

    @Test
    @DisplayName("한줄 선 true/false 그리기")
    void init2() {
        Line line = Line.of(4, () -> false);

        line.getPoints().forEach(point -> {
            System.out.print(point.isLeft() + " ");
        });

        assertThat(line.getPoints().get(0).isLeft()).isEqualTo(false);
        assertThat(line.getPoints().get(1).isLeft()).isEqualTo(false);
        assertThat(line.getPoints().get(2).isLeft()).isEqualTo(false);
        assertThat(line.getPoints().get(3).isLeft()).isEqualTo(false);
    }
}