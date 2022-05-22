package ladder;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNamesTest {

  private static final List<String> PLAYER_NAMES_LIST = List.of("a", "bb", "ccc", "dddd", "eeeee");
  public static final PlayerNames PLAYER_NAMES_1 = new PlayerNames(PLAYER_NAMES_LIST);


  @Test
  void PlayerNames_생성_성공() {
    List<String> names = List.of("a", "bb", "ccc", "dddd", "eeeee");
    assertDoesNotThrow(() -> new PlayerNames(names));
  }

  @ParameterizedTest(name = "{0}은 잘못된 이름이므로 PlayerNames 생성 실패")
  @MethodSource("invalidNames")
  void PlayerNames_생성_실패(List<String> invalidNames) {
    assertThrows(IllegalArgumentException.class, () -> new PlayerNames(invalidNames));
  }

  private static Stream<Arguments> invalidNames() {
    return Stream.of(
        Arguments.of(emptyList()),
        Arguments.of(List.of("123456"))
    );
  }

  @Test
  void playerNumber_성공() {
    assertThat(PLAYER_NAMES_1.playerNumber()).isEqualTo(PLAYER_NAMES_LIST.size());
  }

  @Test
  void playerNames_성공() {
    assertThat(PLAYER_NAMES_1.playerNames().containsAll(PLAYER_NAMES_LIST)).isTrue();
    assertThat(PLAYER_NAMES_LIST.containsAll(PLAYER_NAMES_1.playerNames())).isTrue();
  }

  @Test
  void of_성공() {
    assertDoesNotThrow(() -> PlayerNames.of(" a , bb, ccc ,dddd, eeeee"));
  }

  @ParameterizedTest(name = "{0}은 잘못된 문자열이므로 PlayerNames 생성 실패")
  @ValueSource(strings = {"", ",", "a,", "aaaaaa"})
  void of_실패(String invalidNames) {
    assertThrows(IllegalArgumentException.class, () -> PlayerNames.of(invalidNames));
  }
}
