package ladder.domain;

import ladder.exception.InvalidPointException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
        assertThat(Point.first(true).last().movedDirection()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("아래로 지나갈 때 테스트")
    @Test
    void pass(){
        assertThat(Point.first(false).movedDirection()).isEqualTo(Direction.PASS);
    }

    @DisplayName("마지막 값 테스트")
    @Test
    void last(){
        Point point = Point.first(false).last();
        assertThat(point).isEqualTo(Point.first(false).last());
    }

    @DisplayName("값이 연속적으로 true 인 경우는 Exception 테스트")
    @Test
    void exception(){
        assertThatExceptionOfType(InvalidPointException.class)
                .isThrownBy(()->{
                    Point point = Point.first(true).next(true);
                    assertThat(point).isEqualTo(Point.first(false).last());
                }).withMessageMatching("인접 한 열의 Point 연속으로 true 입니다. false 를 입력하세요.");

    }
}
