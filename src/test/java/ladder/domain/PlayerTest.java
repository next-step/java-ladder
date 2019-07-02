package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

  @DisplayName("유저 생성 테스트")
  @Test
  void create() {
    Player player = Player.of("test");
    assertThat(player).isEqualTo(Player.of("test"));
  }

  @DisplayName("유효성 검증 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"", "test123"})
  void validate(String name) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Player.of(name));
  }
}
