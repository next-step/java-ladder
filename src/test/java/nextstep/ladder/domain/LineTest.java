package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("라인 생성 테스트")
    void fromLine() {
        Point point1 = Point.from(0, Direction.RIGHT);
        Point point2 = Point.from(1, Direction.LEFT);
        Point point3 = Point.from(2, Direction.FORWARD);

        Line line = Line.from(Arrays.asList(point1, point2, point3));

        assertThat(line.getPoints().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자의 다음 인덱스 리턴 테스트")
    void getNextIndex() {
        Point point1 = Point.from(0, Direction.RIGHT);
        Point point2 = Point.from(1, Direction.LEFT);
        Point point3 = Point.from(2, Direction.FORWARD);

        Line line = Line.from(Arrays.asList(point1, point2, point3));

        assertThat(line.getNextIndex(0)).isEqualTo(1);
    }

}
