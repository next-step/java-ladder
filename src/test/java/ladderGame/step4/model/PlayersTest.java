package ladderGame.step4.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

  @DisplayName("사용자명을 쉼표단위로 여러개 입력하여 사용자를 생성.")
  @Test
  void createPlayersTest() {
    List<PlayerName> of = Players.of("user1,user2");
    assertThat(of.size()).isEqualTo(2);

    assertThat(new Players(of)).isEqualTo(new Players(of));
  }

  @DisplayName("입력값 기준으로 사용자 명수 검증 테스트.")
  @Test
  void playersCountTest() {
    assertThatThrownBy(() -> new Players(Players.of(",,,")))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("입력된 사용자명의 문자열 리스트를 반환.")
  @Test
  void writePlayersName() {
    Players players = new Players(Players.of("user1,user2"));

    assertThat(players.playersName().size()).isEqualTo(2);
    assertThat(players.playersName()).containsExactly("user1","user2");
  }

  @DisplayName("이름이 같은 객체의 인덱스 반환.")
  @Test
  void findNameIndex() {
    Players players = new Players(Players.of("user1,user2"));

    assertThat(players.findIndexByName("user2")).isEqualTo(1);
  }
}