package nextstep.ladder.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

  @Test
  void testCreatePlayers() {
    String players = "pobi, crong, jk";

    Players playersList = new Players(players);

    AssertionsForClassTypes.assertThat(playersList.size()).isEqualTo(3);
    AssertionsForClassTypes.assertThat(playersList.toConsoleOutput()).isEqualTo(" pobi crong    jk");
  }

  @Test
  void testCreatePlayersWithLessThan2Players() {
    String players = "pobi";

    AssertionsForClassTypes.assertThatThrownBy(() -> new Players(players))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(String.format("참여자는 %d명 이상이어야 합니다.", Players.MIN_SIZE));
  }

  @Test
  void testCreatePlayersWithDuplicateNames() {
    String players = "pobi, crong, pobi";

    AssertionsForClassTypes.assertThatThrownBy(() -> new Players(players))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("참여자 이름은 중복될 수 없습니다.");
  }

  @Test
  void testContains() {
    Players players = new Players("pobi, crong, jk");

    assertThat(players.contains("pobi")).isTrue();
    assertThat(players.contains("crong")).isTrue();
    assertThat(players.contains("jk")).isTrue();
    assertThat(players.contains("spy")).isFalse();
  }

  @Test
  void testPlayAll() {
    Players players = new Players("pobi, crong, jk");
    Ladder ladder = new Ladder(3, players, () -> true, "0, 1, 2");

    List<String> results = players.playAll(ladder).values().stream()
            .map(String::trim)
            .collect(Collectors.toList());

    assertThat(results).isEqualTo(Arrays.asList("1", "0", "2"));
  }
}