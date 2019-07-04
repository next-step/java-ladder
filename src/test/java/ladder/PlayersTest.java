package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayersTest {

  @Test
  public void 생성테스트() {
    String playersName = "pobi,atom";
    Players players = new Players(playersName);
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {"", " "})
  public void 빈값은_이름이_될수없다(String inputPlayerName) {
    assertThatThrownBy(() -> {
      Players players = new Players(inputPlayerName);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("players 이름을 입력하세요");

  }

  @Test
  public void 플레이어는_최소2명이다() {
    assertThatThrownBy(() -> {
      Players players = new Players("jun");
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("player 는 최소 2명입니다.");
  }

  @Test
  public void player이름을_포맷으로_가지고온다() {
    String playerNames = "lee,chang,junn";
    String result = "lee   chang junn  ";
    assertThat(new Players(playerNames).toString()).isEqualTo(result);
  }

}
