package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import ladder.domain.strategy.FixedLadderConnectStrategy;
import ladder.domain.strategy.LadderConnectStrategy;
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

    assertThat(ladderGame.getLadder().getLadderWidth()).isEqualTo(gameUsers.getUserSize());
    assertThat(ladderGame.getLadderHeight()).isEqualTo(height);
    assertThat(ladderGame.getGameUsers()).isEqualTo(gameUsers);
    assertThat(ladderGame.getGameResults()).isEqualTo(gameResults);
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

  @Test
  @DisplayName("유저별 사다리 게임 결과가 정확한지 확인")
  void getResult() {
    GameUsers gameUsers = GameUsers.from("pobi,test,crong,hihi");
    GameResults gameResults = GameResults.from("꽝,3000,1000,꽝");
    LadderConnectStrategy ladderConnectStrategy = new FixedLadderConnectStrategy(List.of(
        List.of(true, false, true, false), List.of(false, true, false, false),
        List.of(false, false, true, false), List.of(false, false, true, false)));
    Map<String, String> userGameResultExpect = Map.of("pobi", "1000", "test", "꽝", "crong", "꽝",
        "hihi", "3000");
    int height = 4;

    LadderGame ladderGame = LadderGame.of(gameUsers, gameResults, height, ladderConnectStrategy);

    for (Entry<String, String> resultExpect : userGameResultExpect.entrySet()) {
      GameResult gameResult = ladderGame.getUserGameResult(GameUser.from(resultExpect.getKey()));
      assertThat(gameResult.getResult()).isEqualTo(resultExpect.getValue());
    }
    assertThat(ladderGame.getUserGameResult(GameUser.from("anony"))).isNull();
  }

  @Test
  @DisplayName("전체 사다리 게임 결과가 정확한지 확인")
  void getResultAll() {
    GameUsers gameUsers = GameUsers.from("pobi,test,crong,hihi");
    GameResults gameResults = GameResults.from("꽝,3000,1000,꽝");
    LadderConnectStrategy ladderConnectStrategy = new FixedLadderConnectStrategy(List.of(
        List.of(true, false, true, false), List.of(false, true, false, false),
        List.of(false, false, true, false), List.of(false, false, true, false)));
    int height = 4;
    GameResults resultExpect = GameResults.from("1000,꽝,꽝,3000");

    LadderGame ladderGame = LadderGame.of(gameUsers, gameResults, height, ladderConnectStrategy);
    GameResults resultAll = ladderGame.getAllGameResult();

    assertThat(resultAll).usingRecursiveComparison().isEqualTo(resultExpect);
  }
}
