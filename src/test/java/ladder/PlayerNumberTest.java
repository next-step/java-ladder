package ladder;

import static ladder.PlayerNamesTest.PLAYER_NAMES_1;
import static ladder.PlayerNumber.MIN_PLAYER_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNumberTest {

  public static final PlayerNumber PLAYER_NUMBER_1 = PlayerNumber.from(PLAYER_NAMES_1);
  
  @Test
  void PlayerNumber_생성_성공() {
    assertDoesNotThrow(() -> new PlayerNumber(MIN_PLAYER_NUMBER));
  }

  @Test
  void PlayerNumber_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new PlayerNumber(MIN_PLAYER_NUMBER - 1));
  }

  @DisplayName("PlayerNumber(2)는 1보다 크기 때문에 True 반환")
  @Test
  void isMoreThan_성공() {
    PlayerNumber PlayerNumber = new PlayerNumber(2);

    assertThat(PlayerNumber.isMoreThan(1)).isTrue();
  }

  @ParameterizedTest(name = "PlayerNumber(2)는 {0}보다 크지않기 때문에 False 반환")
  @ValueSource(ints = {2, 3})
  void isMoreThan_실패(int number) {
    PlayerNumber PlayerNumber = new PlayerNumber(2);

    assertThat(PlayerNumber.isMoreThan(number)).isFalse();
  }

  @Test
  void PlayerNames로_from_성공() {
    assertDoesNotThrow(() -> PlayerNumber.from(PLAYER_NAMES_1));
  }

  @Test
  void Line으로_from_성공() {

  }
}
