package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

  @Test
  public void 생성테스트() {
    Player player = new Player("jun");
    Player player1 = new Player("jun");
    assertThat(player.equals(player1)).isTrue();
  }

  @Test
  public void 이름은_다섯글자를_못넘어간다() {
    assertThatThrownBy(() -> {
      Player player1 = new Player("changjun");
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 다섯글자 이하여야 합니다.");
  }

  @Test
  public void 이름을_자리수에_맞추어_공백을_추가해서_return한다() {
    int length = 6;
    Player player = new Player("lee");
    assertThat(player.nameFormat(length)).isEqualTo("lee   ");
    assertThat(player.nameFormat(length).length()).isEqualTo(length);
  }

}