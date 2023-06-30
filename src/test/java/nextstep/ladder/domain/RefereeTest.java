package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import nextstep.ladder.domain.dto.GameResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefereeTest {

  private Ladder ladder;
  private PlayerNames playerNames;
  private GameResults gameResults;

  @BeforeEach
  void setUp() {
    playerNames = new PlayerNames(new String[] {"pobi", "honux", "crong", "jk"});
    ladder = LadderFactory.createLadder(1, playerNames.size(), new OnlyBarLadderBarStatusDecider());
    gameResults = new GameResults(Arrays.asList("꽝", "5000", "꽝", "3000"));
  }

  @Test
  void getResult_pass() {
    Referee referee = new Referee();
    GameResults actual = referee.getResults(ladder, playerNames, gameResults);

    assertEquals("5000", actual.getResult(0));
    assertEquals("꽝", actual.getResult(1));
    assertEquals("3000", actual.getResult(2));
    assertEquals("꽝", actual.getResult(3));

    Ladder ladder2 = LadderFactory.createLadder(2, playerNames.size(), new OnlyBarLadderBarStatusDecider());
    GameResults actual2 = referee.getResults(ladder2, playerNames, gameResults);

    assertEquals("꽝", actual2.getResult(0));
    assertEquals("5000", actual2.getResult(1));
    assertEquals("꽝", actual2.getResult(2));
    assertEquals("3000", actual2.getResult(3));
  }
}

// 무조건 BAR / EMPTY / BAR / EMPTY...를 반환
class OnlyBarLadderBarStatusDecider implements LadderBarStatusDecider {

  @Override
  public LadderBarStatus decide(LadderBarStatus ladderBarStatus) {
    if (!ladderBarStatus.isEmpty()) {
      return LadderBarStatus.EMPTY;
    }

    return LadderBarStatus.BAR;
  }
}