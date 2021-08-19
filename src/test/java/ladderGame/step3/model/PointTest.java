package ladderGame.step3.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladderGame.step3.util.RandomMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

  @DisplayName("포인트 인덱스 값 기준으로 이동한 거리를 반환.")
  @ParameterizedTest
  @CsvSource(value = {"0,false,true,1", "1,true,false,0", "0,false,false,0"})
  void moveForward(int startPoint, boolean before, boolean current, int resultPoint) {
    Point point = new Point(startPoint, new Location(before, current));

    assertThat(point.move()).isEqualTo(resultPoint);
  }

  @DisplayName("포인트 인덱스가 0에서 후진이 발생하는 경우 검증.")
  @Test
  void invalidMove() {
    Point point = new Point(0, new Location(true, false));
    assertThatThrownBy(point::move)
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("첫 포인트 생성.")
  @Test
  void createFirst() {
    Point point = Point.first(false);

    assertThat(point).isEqualTo(new Point(0,new Location(false,false)));
  }

  @DisplayName("첫포인트 기준 다음 포인트 생성.")
  @Test
  void createNextPoint() {

    Point firstPoint = Point.first(true);
    Point next = firstPoint.next(1, false);

    assertThat(next).isEqualTo(new Point(1,new Location(true,false)));
  }

  @DisplayName("마지막 포인트 생성.")
  @Test
  void createLast() {
    Point firstPoint = Point.first(RandomMove.createRandomMoveValue());
    Point next = firstPoint.next(1, RandomMove.createRandomMoveValue()).last(2, false);
    Point last = next.last(2, false);

    assertThat(last).isEqualTo(new Point(2,new Location(false,false)));
  }
}