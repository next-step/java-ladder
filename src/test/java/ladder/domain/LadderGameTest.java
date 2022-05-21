package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

  @Test
  @DisplayName("사용자 이름, 사다리 높이를 받아서 게임이 잘 생성되는지 확인")
  void of() {
    GameUsers gameUsers = GameUsers.from("pobi,test,crong");
    GameResults gameResults = GameResults.from("꽝,100,1000");
    int height = 5;
    LadderGame ladderGame = LadderGame.of(gameUsers, gameResults, height, 10);

    assertThat(ladderGame.getLadderHeight()).isEqualTo(height);
    assertThat(ladderGame.getGameUsers()).isEqualTo(gameUsers);
    assertThat(ladderGame.getGameResults()).isEqualTo(gameResults);
  }

  @Test
  @DisplayName("사용자 이름과 게임 결과 개수가 맞지 않을때 에러")
  void exception() {
    GameUsers gameUsers = GameUsers.from("pobi,test,crong");
    GameResults gameResults = GameResults.from("꽝,100,1000,10");

    assertThatThrownBy(() -> LadderGame.of(gameUsers, gameResults, 5, 10))
        .isInstanceOf(InvalidParameterException.class);
  }

  @RepeatedTest(100)
  @DisplayName("유저별 사다리 게임 결과가 중복되지 않게 나오는지 확인")
  void getResult() {
    GameUsers gameUsers = GameUsers.from("pobi,test,crong,hihi");
    GameResults gameResults = GameResults.from("꽝,1000,2000,3000");
    List<GameResult> resultAll = new ArrayList<>();

    LadderGame ladderGame = LadderGame.of(gameUsers, gameResults, 5, gameUsers.getUserSize());
    for (GameUser user : gameUsers.getValues()) {
      resultAll.add(ladderGame.getUserGameResult(user));
    }

    assertThat(resultAll).containsExactlyInAnyOrderElementsOf(gameResults.getValues());
  }

  @RepeatedTest(100)
  @DisplayName("유저 전체 사다리 게임 결과가 중복되지 않게 나오는지 확인")
  void getAllResult() {
    GameUsers gameUsers = GameUsers.from("pobi,test,crong,hihi");
    GameResults gameResults = GameResults.from("꽝,1000,2000,3000");

    LadderGame ladderGame = LadderGame.of(gameUsers, gameResults, 5, gameUsers.getUserSize());
    GameResults allResult = ladderGame.getAllGameResult();

    assertThat(allResult.getValues()).containsExactlyInAnyOrderElementsOf(gameResults.getValues());
  }

}
