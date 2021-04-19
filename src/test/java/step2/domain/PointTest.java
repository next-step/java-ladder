package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("첫 번째 Point생성 테스트")
    void createFirstPointTest() {
        Point firstPoint = Point.first(new FixedGenerator(true));
        assertThat(firstPoint).isEqualTo(Point.first(new FixedGenerator(true)));
    }

    @Test
    @DisplayName("중간 Point생성 테스트")
    void createMiddlePointTest() {
        Point firstPoint = Point.first(new FixedGenerator(false));
        Point middlePoint = Point.middle(firstPoint, new FixedGenerator(true));

        assertThat(middlePoint).isEqualTo(Point.middle(firstPoint, new FixedGenerator(true)));
    }

    @Test
    @DisplayName("마지막 Point생성 테스트")
    void createLastPointTest() {
        Point firstPoint = Point.first(new FixedGenerator(false));
        Point lastPoint = Point.last(firstPoint);

        assertThat(lastPoint).isEqualTo(Point.middle(firstPoint, new FixedGenerator(false)));
    }

    @Test
    @DisplayName("point가 오른쪽으로 이동하면 인덱스가 1 증가")
    void movingRightPointTest() {
        Point firstPoint = Point.first(new FixedGenerator(true));
        assertThat(firstPoint.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("point가 왼쪽으로 이동하면 인덱스가 1감소")
    void movingLeftPointTest(){
        Point firstPoint = Point.first(new FixedGenerator(true));
        Point middlePoint = Point.middle(firstPoint, new FixedGenerator(false));

        assertThat(firstPoint.move()).isEqualTo(1);
        assertThat(middlePoint.move()).isEqualTo(0);
    }
}
