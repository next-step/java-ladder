package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

  public static final List<Player> PLAYER_NAME_LIST_1 = Stream.of("a", "bb", "ccc", "dddd", "eeeee")
      .map(Player::of)
      .collect(Collectors.toUnmodifiableList());

  @ParameterizedTest(name = "{0}으로 Player 생성 성공")
  @ValueSource(strings = {"a", "bb", "ccc", "dddd", "eeeee"})
  void of_생성_성공(String validPlayer) {
    assertDoesNotThrow(() -> Player.of(validPlayer));
  }

  @DisplayName("all으로 캐싱 Player 생성 성공")
  @Test
  void Player_ALL_생성_성공() {
      assertThat(Player.ALL).isEqualTo(Player.of("all"));
  }

  @DisplayName("exit으로 캐싱 Player 생성 성공")
  @Test
  void Player_EXIT_생성_성공() {
    assertThat(Player.EXIT).isEqualTo(Player.of("exit"));
  }

  @Test
  void equals_성공() {
    assertThat(Player.of("test")).isEqualTo(Player.of("test"));
  }

  @ParameterizedTest(name = "{0}으로 Player 생성 실패")
  @ValueSource(strings = {"", " ", "123456"})
  void Player_생성_실패(String invalidPlayer) {
    assertThrows(IllegalArgumentException.class, ()-> Player.of(invalidPlayer));
  }

  @ParameterizedTest(name = "{0}으로 toString 성공")
  @ValueSource(strings = {"a", "bb", "ccc", "dddd", "eeeee"})
  void toString_성공(String rawPlayer) {
    Player name = Player.of(rawPlayer);
    assertThat(name.toString()).isEqualTo(rawPlayer);
  }
}
