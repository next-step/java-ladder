package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

  @DisplayName("쉼표로 구분된 이름으로 Players 생성")
  @Test
  void createFromNames() {
    Players players = Players.from("pobi,honux,crong,jk");
    assertThat(players.size()).isEqualTo(4);
  }

  @DisplayName("Players에서 특정 위치의 Player 조회")
  @Test
  void getPlayerAtPosition() {
    Players players = Players.from("pobi,honux,crong,jk");
    Person person = players.get(0);
    assertThat(person.getName()).isEqualTo("pobi");
  }

  @DisplayName("빈 이름으로 Players 생성 시 예외 발생")
  @Test
  void createWithEmptyName() {
    assertThatThrownBy(() -> Players.from("pobi,,crong"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Players의 모든 참가자 이름 목록 조회")
  @Test
  void getNames() {
    Players players = Players.from("pobi,honux,crong,jk");
    List<String> names = players.getNames();
    assertThat(names).containsExactly("pobi", "honux", "crong", "jk");
  }
}
