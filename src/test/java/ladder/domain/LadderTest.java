package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.store.NameStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  private Players players;

  @BeforeEach
  void setUp() {
    players = new Players(NameStore.createPlayers("pobi,crong,honux,jk"));
  }

  @Test
  @DisplayName("[Ladder] 최대 높이만큼 사다리 생성 테스트")
  void createLadderTest() {
    Ladder ladder = new Ladder(players, 5);

    assertThat(ladder.lines().size()).isEqualTo(5);
  }

  @Test
  @DisplayName("[Ladder] 사다리 최소 높이 검증 테스트")
  void validateLadderHeightTest() {
    assertThatThrownBy(() -> new Ladder(players, 1))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
