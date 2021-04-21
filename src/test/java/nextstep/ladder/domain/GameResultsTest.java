package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultsTest {

  @Test
  @DisplayName("GameResult가 생성된다.")
  void create() {
    assertThat(new GameResults()).isEqualTo(new GameResults());
  }
}
