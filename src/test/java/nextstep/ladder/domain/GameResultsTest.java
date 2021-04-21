package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultsTest {

  @Test
  @DisplayName("GameResult가 생성된다.")
  void create() {
    assertThat(new GameResults()).isEqualTo(new GameResults());
  }

  @Test
  @DisplayName("GameResult는 빈 Map으로 생성된 것과 동일하다.")
  void createWithEmptyMap() {
    assertThat(new GameResults(new HashMap<Person, Result>())).isEqualTo(new GameResults());
  }
}
