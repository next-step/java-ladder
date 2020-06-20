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
      Point point = Point.first(true);
      assertThat(point.getPosition()).isEqualTo(new Position(0));
      assertThat(point.left()).isFalse();

      Point point2 = Point.first(false);
      assertThat(point2.getPosition()).isEqualTo(new Position(0));
      assertThat(point2.left()).isFalse(); //인수에 관계없이 false
    }

    @Test
    @DisplayName("중간 포인트 테스트")
    void checkMidPoint(){
        Point point = Point.first(true);
        Point point2 = point.mid();
        Point point3 = point2.mid();

        assertThat(point2.getPosition()).isEqualTo(new Position(1));
        assertThat(point3.getPosition()).isEqualTo(new Position(2));
        assertThat(point2.left()).isTrue();
        assertThat(point2.right()).isFalse();
    }

    @Test
    @DisplayName("마지막 포인트 테스트")
    void checkLastPoint(){
        Point point = Point.first(true);
        Point point2 = point.mid();
        Point point3 = point2.mid();
        Point lastPoint = point3.last();

        assertThat(lastPoint.getPosition()).isEqualTo(new Position(3));
        assertThat(lastPoint.right()).isFalse();
    }
}
