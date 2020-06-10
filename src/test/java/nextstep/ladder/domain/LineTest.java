package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    private Line line = Line.newInstance(Arrays.asList(Point.newInstance(true), Point.newInstance(false)));

    @DisplayName("포인트 리스트가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLineIfPointsIsNull() {
        assertThatThrownBy(() -> Line.newInstance(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("포인트 리스트가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLineIfPointsContainsIsNull() {
        assertThatThrownBy(() -> {
            List<Point> points = Arrays.asList(null, Point.newInstance(false));
            Line.newInstance(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("가로 라인이 겹치면 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLineIfOverlapPoint() {
        assertThatThrownBy(() -> {
            List<Point> points = Arrays.asList(Point.newInstance(true), Point.newInstance(true));
            Line.newInstance(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인을 생성할 수 있다.")
    @Test
    void canCreateLine() {
        assertThat(this.line).isInstanceOf(Line.class);
    }

    @DisplayName("라인 리스트를 얻을 수 있다.")
    @Test
    void canToList() {
        assertThat(this.line.toList()).isInstanceOf(List.class);
    }

    @DisplayName("이동할 수 있다.")
    @Test
    void canMove() {
        assertThat(this.line.move(Position.newInstance(0))).isEqualTo(Position.newInstance(1));
        assertThat(this.line.move(Position.newInstance(1))).isEqualTo(Position.newInstance(0));
    }
}
