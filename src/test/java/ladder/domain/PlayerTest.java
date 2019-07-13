package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

  @DisplayName("유저 생성 테스트")
  @Test
  void create() {
    Player player = Player.of("test");
    assertThat(player).isEqualTo(Player.of("test"));
  }

  @DisplayName("라인 생성 테스트")
  @Test
  void line_create() {
    Players players = Players.of("test, test2, test3");
    assertThat(players.size()).isEqualTo(3);
  }

  @DisplayName("유효성 검증 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"", "test123"})
  void validate(String name) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Player.of(name));
  }

}
