package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

  @DisplayName("String을 인자로 받아 Player를 생성할 수 있다.")
  @Test
  void create() {
    Player player = Player.of("yeny");
    Player expected = new Player(new Name("yeny"));

    assertThat(player).isEqualTo(expected);
  }

  @DisplayName("이름에 null이 들어오면 예외가 발생한다.")
  @Test
  void createWithNull() {
    assertThatThrownBy(() -> new Player(null)).isInstanceOf(IllegalArgumentException.class);
  }
}
