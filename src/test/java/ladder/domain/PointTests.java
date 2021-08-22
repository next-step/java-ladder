package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTests {
    @DisplayName("생성 테스트")
    @Test
    void create(){
        Point firstPoint = Point.first(true);

        assertThat(firstPoint).isEqualTo(Point.first(true));
    }

    @DisplayName("오른쪽 테스트")
    @Test
    void right(){
        assertThat(Point.first(true).movedDirection()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("왼쪽 테스트")
    @Test
    void left(){
        assertThat(Point.first(true).next(false).movedDirection()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("아래로 지나갈 때 테스트")
    @Test
    void pass(){
        assertThat(Point.first(false).movedDirection()).isEqualTo(Direction.PASS);
    }
}
