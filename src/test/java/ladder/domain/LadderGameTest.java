package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.security.InvalidParameterException;
import ladder.domain.strategy.RandomLadderConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

  @Test
  @DisplayName("사용자 이름, 사다리 높이를 받아서 게임이 잘 생성되는지 확인")
  void of() {
    GameUsers gameUsers = GameUsers.from("pobi,test,crong");
    GameResults gameResults = GameResults.from("꽝,100,1000");
    int height = 5;
    LadderGame ladderGame = LadderGame.of(gameUsers, gameResults, height,
        new RandomLadderConnectStrategy(height, gameUsers.getUserSize()));

    assertThat(ladderGame.getLadderWidth()).isEqualTo(gameUsers.getUserSize());
    assertThat(ladderGame.getLadderHeight()).isEqualTo(height);
    assertThat(ladderGame.getUserNames()).isEqualTo(gameUsers);
  }

  @Test
  @DisplayName("사용자 이름과 게임 결과 개수가 맞지 않을때 에러")
  void exception() {
    GameUsers gameUsers = GameUsers.from("pobi,test,crong");
    GameResults gameResults = GameResults.from("꽝,100,1000,10");
    int height = 5;
    assertThatThrownBy(() -> LadderGame.of(gameUsers, gameResults, height,
        new RandomLadderConnectStrategy(5, 3)))
        .isInstanceOf(InvalidParameterException.class);
  }
}
