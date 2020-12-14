package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @DisplayName("Point 생성 테스트")
    @Test
    void pointCreationTest(){
        Point point = new Point(0, Direction.first(true));
        assertThat(point).isEqualTo(new Point(0, Direction.first(true)));
    }

    @DisplayName("Point first 테스트")
    @Test
    void firstPointCreationTest(){
        assertThat(Point.first(true).move()).isEqualTo(1);
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @DisplayName("point 이동 변화가 없는 경우")
    @Test
    void next_stay(){
        Point second = Point.first(false).next(false);
        assertThat(second.move()).isEqualTo(1);
    }

    @DisplayName("point 왼쪽 이동 test")
    @Test
    void next_left(){
        Point second = Point.first(true).next(false);
        assertThat(second.move()).isEqualTo(0);
    }

    @DisplayName("point 오른쪽 이동 test")
    @Test
    void next_right(){
        Point second = Point.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

    @DisplayName("point 이동 test")
    @Test
    void next(){
        Point second = Point.first(true).next();
        assertThat(second.move()).isEqualTo(0);
    }


}
