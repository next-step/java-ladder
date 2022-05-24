package ladder;

import static java.util.Collections.emptyList;
import static ladder.NameTest.PLAYER_NAME_LIST_1;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

  public static final Players PLAYERS_1 = new Players(PLAYER_NAME_LIST_1);


  @Test
  void PlayerNames_생성_성공() {
    assertDoesNotThrow(() -> new Players(PLAYER_NAME_LIST_1));
  }

  @Test
  void PlayerNames_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Players(emptyList()));
  }

  @Test
  void playerNumber_성공() {
    assertThat(PLAYERS_1.playerNumber()).isEqualTo(PLAYER_NAME_LIST_1.size());
  }

  @Test
  void playerNames_성공() {
    List<String> expected = List.of("a", "bb", "ccc", "dddd", "eeeee");
    Players players = new Players(expected.stream()
        .map(Name::new)
        .collect(Collectors.toUnmodifiableList()));

    List<String> names = players.playerNames()
        .stream()
        .map(Name::toString)
        .collect(Collectors.toUnmodifiableList());

    assertThat(names.containsAll(expected)).isTrue();
    assertThat(expected.containsAll(names)).isTrue();
  }

  @Test
  void isMoreThan_성공() {
    assertThat(PLAYERS_1.isMoreThan(PLAYER_NAME_LIST_1.size() - 1)).isTrue();
  }

  @Test
  void isMoreThan_실패() {
    assertThat(PLAYERS_1.isMoreThan(PLAYER_NAME_LIST_1.size())).isFalse();
  }

  @Test
  void startIndexOf_성공() {
    assertThat(PLAYERS_1.startIndexOf(PLAYER_NAME_LIST_1.get(0))).isEqualTo(0);
  }

  @Test
  void has_성공() {
    assertThat(PLAYERS_1.has(PLAYER_NAME_LIST_1.get(0))).isTrue();
  }

  @Test
  void has_실패() {
    assertThat(PLAYERS_1.has(new Name("없음"))).isFalse();
  }

  @Test
  void of_성공() {
    assertDoesNotThrow(() -> Players.of(" a , bb, ccc ,dddd, eeeee"));
  }

  @ParameterizedTest(name = "{0}은 잘못된 문자열이므로 PlayerNames 생성 실패")
  @ValueSource(strings = {"", ",", "a,", "aaaaaa"})
  void of_실패(String invalidNames) {
    assertThrows(IllegalArgumentException.class, () -> Players.of(invalidNames));
  }
}
