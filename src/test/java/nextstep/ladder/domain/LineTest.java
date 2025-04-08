package nextstep.ladder.domain;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void createLine() {
        List<Boolean> points = List.of(true, false, true);
        Line line = new Line(points);

        assertThat(line.getPoints()).containsExactly(
                new Point(true),
                new Point(false),
                new Point(true)
        );
    }

    @Test
    void 연속된_가로선은_에러() {
        List<Boolean> points = List.of(false, true, true, false);
        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("연속으로 가로점이 존재할 수는 없습니다.");
    }

    @Test
    void 랜덤_선_생성() {
        Line line = Line.createRandomLine(4, new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        });

        assertThat(line).isEqualTo(new Line(List.of(
                true,
                false,
                true
        )));
    }

    @Test
    void 양옆에_선이있으면_이동() {
        Line line = new Line(List.of(true, false, true));
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(3);
        assertThat(line.move(3)).isEqualTo(2);
    }
}