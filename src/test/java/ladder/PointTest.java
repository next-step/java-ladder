package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("라인이 없는 좌표 라인이 있는 좌표 생성 테스트")
    void create_with_new() {
        Point emptyPoint = new Point(false);
        Point filledPoint = new Point( true);

        assertThat(emptyPoint.isFilled()).isFalse();
        assertThat(filledPoint.isFilled()).isTrue();
    }

    @Test
    @DisplayName("라인이 없는 좌표 라인이 있는 좌표 static 생성 테스트")
    void create_static() {
        Point emptyPoint = Point.emptyPoint();
        Point filledPoint = Point.filledPoint();

        assertThat(emptyPoint.isFilled()).isFalse();
        assertThat(filledPoint.isFilled()).isTrue();
    }

}
