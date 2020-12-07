package domain;

import exception.NegativePositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @Test
    @DisplayName("생성자 테스트")
    void ofTest(){
        Point point = Point.of(Position.of(0), Direction.RIGHT);
        assertThat(point.getDirection()).isEqualTo(Direction.RIGHT);
        assertThat(point.getDirection() == Direction.RIGHT).isTrue();
    }

    @Test
    @DisplayName("다음 Point의 Position을 리턴하는 next() 테스트")
    void nextTest() {
        Point point = Point.of(Position.of(0), Direction.RIGHT);
        assertThat(point.next()).isEqualTo(Position.of(1));

        assertThatThrownBy( () ->
            Point.of(Position.of(0), Direction.LEFT).next()
        ).isInstanceOf(NegativePositionException.class);

        Point point2 = Point.of(Position.of(0), Direction.DOWN);
        assertThat(point2.next()).isEqualTo(Position.of(0));
    }
}
