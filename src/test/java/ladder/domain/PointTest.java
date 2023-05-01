package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {

  private Point point;
  private Point nextPoint;

  @BeforeEach
  public void setUp() {
    point = Point.createFirstPoint(() -> true);
    nextPoint = point.createNextPoint(() -> false);
  }

  @Test
  @DisplayName("첫 번째 유저의 포인트는 위치가 0이고, 방향 좌는 false, 우는 true인지 확인 테스트")
  public void create_첫_번째_포인트() {
    assertAll(
            () -> assertThat(point.currentUserPosition()).isEqualTo(0),
            () -> assertThat(point.canMovePrevious()).isFalse(),
            () -> assertThat(point.canMoveNext()).isTrue()
    );
  }

  @Test
  @DisplayName("다음 유저의 포인트의 위치는 1이고, 방향 좌는 true, 우는 false 확인 테스트")
  public void create_두_번째_포인트() {
    assertAll(
            () -> assertThat(nextPoint.currentUserPosition()).isEqualTo(1),
            () -> assertThat(nextPoint.canMovePrevious()).isTrue(),
            () -> assertThat(nextPoint.canMoveNext()).isFalse()
    );
  }

  @Test
  @DisplayName("마지막 유저의 포인트 위치는 2이고, 방향 좌는 false, 우는 false 확인 테스트")
  public void create_마지막_포인트() {
    Point lastPoint = nextPoint.createLastPoint();

    assertAll(
            () -> assertThat(lastPoint.currentUserPosition()).isEqualTo(2),
            () -> assertThat(lastPoint.canMovePrevious()).isFalse(),
            () -> assertThat(lastPoint.canMoveNext()).isFalse()
    );
  }
}
