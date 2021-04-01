package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @Test
  @DisplayName("[Ladder] 최대 높이만큼 사다리 생성 테스트")
  void createLadderTest() {
    Players players = new Players(NameStore.createPlayers("pobi,crong,honux,jk"));
    Ladder ladder = new Ladder(players, 5);

    assertThat(ladder.lines().size()).isEqualTo(5);
  }
}
