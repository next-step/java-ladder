package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LadderGameTest {

  private Users users;
  private LadderGame ladderGame;
  private LadderResult ladderResult;

  @BeforeEach
  public void setUp() {
    users = Users.createUsers("pobi,honux,oneny,twony");
    ladderGame = new LadderGame(users, new Ladder(LadderLine.createPoints(users.countOfUser(), () -> true), 4));
    ladderResult = ladderGame.play(LadderRewards.createRewards("꽝,1000,꽝,5000", users.countOfUser()));
  }

  @Test
  @DisplayName("게임 결과 테스트")
  public void gameResultTest() {
    assertAll(
            () -> assertThat(ladderResult.rewardOfUser("pobi").reward()).isEqualTo("꽝"),
            () -> assertThat(ladderResult.rewardOfUser("honux").reward()).isEqualTo("1000"),
            () -> assertThat(ladderResult.rewardOfUser("oneny").reward()).isEqualTo("꽝"),
            () -> assertThat(ladderResult.rewardOfUser("twony").reward()).isEqualTo("5000"),
            () -> assertThat(ladderResult.rewardOfUser("anony")).isNull()
    );
  }
}
