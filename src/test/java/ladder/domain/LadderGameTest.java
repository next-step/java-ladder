package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

  @Test
  @DisplayName("사용자 이름, 사다리 높이를 받아서 게임이 잘 생성되는지 확인")
  void of() {
    String userNames = "pobi,test,crong";
    int height = 5;
    LadderGame ladderGame = LadderGame.of(userNames, height);

    assertThat(ladderGame.getLadderWidth()).isEqualTo(3);
    assertThat(ladderGame.getLadderHeight()).isEqualTo(height);
    assertThat(ladderGame.getUserNames()).usingRecursiveComparison()
        .isEqualTo(GameUsers.from(userNames));
  }
}
