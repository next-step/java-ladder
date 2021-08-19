package ladderGame.step3.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LocationTest {

  @DisplayName("잘못된 값 생성 일 때.")
  @Test
  void invalidCreate() {
    assertThatThrownBy(()->new Location(true,true))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("라인의 첫번째 포인트의 기본값을 생성.")
  @ParameterizedTest
  @CsvSource(value = {"true, FORWARD","false, HOLD"})
  void firstPoint(boolean current, String direction) {
    Location location = Location.first(current);
    assertThat(location.movement()).isEqualTo(Direction.valueOf(direction));
  }

  @DisplayName("위치 이동이 그대로일 때.")
  @Test
  void stopMoving() {
    Location location = Location.first(false).nextLocation(false);
    assertThat(location.movement()).isEqualTo(Direction.HOLD);
  }

  @DisplayName("위치가 앞으로 이동할 때.")
  @Test
  void stepForward() {
    Location location = Location.first(false).nextLocation(true);
    assertThat(location.movement()).isEqualTo(Direction.FORWARD);
  }

  @DisplayName("위치가 앞에서 뒤로 이동할 때.")
  @Test
  void goToTheBack() {
    Location location = Location.first(true).nextLocation(false);
    assertThat(location.movement()).isEqualTo(Direction.BACK);
  }

  @DisplayName("라인 마지막 포인트를 생성.")
  @ParameterizedTest
  @CsvSource(value = {"true, false, HOLD","false, true, BACK"})
  void last(boolean before, boolean current, String direction) {
    Location location = Location.first(before).nextLocation(current).last();
    assertThat(location.movement()).isEqualTo(Direction.valueOf(direction));
  }
}