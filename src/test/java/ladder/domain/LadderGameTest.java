package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

  @Test
  @DisplayName("사용자 이름, 사다리 높이를 받아서 게임이 잘 생성되는지 확인")
  void of() {
    String userNames = "pobi,test,crong";
    String gameResults = "꽝,100,1000";
    int height = 5;
    LadderGame ladderGame = LadderGame.of(userNames, gameResults, height);

    assertThat(ladderGame.getLadderWidth()).isEqualTo(3);
    assertThat(ladderGame.getLadderHeight()).isEqualTo(height);
    assertThat(ladderGame.getUserNames()).usingRecursiveComparison()
        .isEqualTo(GameUsers.from(userNames));
  }

  @Test
  @DisplayName("사용자 이름과 게임 결과 개수가 맞지 않을때 에러")
  void exception() {
    String userNames = "pobi,test,crong";
    String gameResults = "꽝,100,1000,10";
    int height = 5;
    assertThatThrownBy(() -> LadderGame.of(userNames, gameResults, height))
        .isInstanceOf(InvalidParameterException.class);
  }
}
