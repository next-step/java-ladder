package ladderGame.step4.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

  @DisplayName("첫포인트 기준 다음 포인트 생성.")
  @Test
  void createNextPoint() {

    Point firstPoint = new Point(0, Location.first(true));
    Point next = new Point(1, firstPoint.nextLocation(false));

    assertThat(next).isEqualTo(new Point(1,new Location(true,false)));
  }

  @DisplayName("마지막 포인트 생성.")
  @Test
  void createLast() {
    Point firstPoint = new Point(0, Location.first(true));
    Point next = new Point(1, firstPoint.nextLocation(false));
    Point last = new Point(2, next.lastLocation());

    assertThat(last).isEqualTo(new Point(2,new Location(false,false)));
  }

  @DisplayName("0 이하의 위치값일때 에러 검증 테스트.")
  @Test
  void invalidCreate() {
    assertThatThrownBy(() -> new Point(-1,Location.first(false)))
        .isInstanceOf(IllegalArgumentException.class);
  }
}