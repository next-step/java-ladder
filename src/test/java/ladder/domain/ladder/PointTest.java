package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("포인트 생성")
    void create() {
        Point point = new Point(new Position(3), new Direction(true, false));
        assertThat(point).isEqualTo(new Point(new Position(3), new Direction(true, false)));
    }

    @Test
    @DisplayName("첫 포인트 생성 후 포지션 확인")
    void createFirstPoint() {
        Point firstPoint = Point.createFirstPoint();
        assertThat(firstPoint.getPosition()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("그 다음 포인트 생성 후 포지션 확인")
    void createPoint() {
        Point point = Point.createPoint(0);
        assertThat(point.getPosition()).isEqualTo(new Position(1));
    }

}
