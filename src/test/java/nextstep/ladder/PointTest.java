package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ladder.domain.Point;
import ladder.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("첫번째 포인트 테스트")
    void checkfirstPoint(){
      Point point = Point.first(() -> true);
      assertThat(point.getPosition()).isEqualTo(Position.of(0));
      assertThat(point.getDirection().leftLine()).isFalse();

      Point point2 = Point.first(() -> false);
      assertThat(point2.getPosition()).isEqualTo(Position.of(0));
      assertThat(point2.getDirection().leftLine()).isFalse(); //인수에 관계없이 false
    }

    @Test
    @DisplayName("중간 포인트 테스트")
    void checkMidPoint(){
        Point point = Point.first(() -> true);
        Point point2 = point.mid();
        Point point3 = point2.mid();

        assertThat(point2.getPosition()).isEqualTo(Position.of(1));
        assertThat(point3.getPosition()).isEqualTo(Position.of(2));
        assertThat(point2.getDirection().leftLine()).isTrue();
        assertThat(point2.getDirection().rightLine()).isFalse();
    }

    @Test
    @DisplayName("마지막 포인트 테스트")
    void checkLastPoint(){
        Point point = Point.first(() -> true);
        Point point2 = point.mid();
        Point point3 = point2.mid();
        Point lastPoint = point3.last();

        assertThat(lastPoint.getPosition()).isEqualTo(Position.of(3));
        assertThat(lastPoint.getDirection().rightLine()).isFalse();
    }
}
