package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

  @DisplayName("생성자로 Player를 생성한다.")
  @Test
  void createByConstructor() {
    Player player = new Player(new Name("yeny"));
    assertThat(player).isNotNull().isInstanceOf(Player.class);
  }

  @DisplayName("정적 팩터리 메서드로 Player를 생성한다.")
  @Test
  void createByFactoryMethod() {
    Player player = Player.of("yeny");
    assertThat(player).isNotNull().isInstanceOf(Player.class);
  }

  @DisplayName("이름에 null이 들어오면 예외가 발생한다.")
  @Test
  void createWithNull() {
    assertThatThrownBy(() -> new Player(null)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("String 타입의 이름을 얻는다.")
  @Test
  void getName() {
    Player player = new Player(new Name("yeny"));
    assertThat(player.getName()).isEqualTo("yeny");
  }
}
