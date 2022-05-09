package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

  @Test
  @DisplayName("사다리 게임이 잘 생성되는지 확인")
  void of() {
    UserNames userNames = UserNames.of("pobi,test,crong");
    int height = 5;
    LadderGame ladderGame = LadderGame.of(userNames, height);

    assertThat(ladderGame.getUserSize()).isEqualTo(3);
    assertThat(ladderGame.getLadderHeight()).isEqualTo(height);
  }
}
