package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import nextstep.ladder.domain.dto.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefereeTest {

  private Ladder ladder;
  private PlayerNames playerNames;
  private Rewards rewards;

  @BeforeEach
  void setUp() {
    playerNames = new PlayerNames(new String[] {"pobi", "honux", "crong", "jk"});
    ladder = LadderFactory.createLadder(1, playerNames.size(), new OnlyBarLadderBarStatusDecider());
    rewards = new Rewards(Arrays.asList("꽝", "5000", "꽝", "3000"));
  }

  @Test
  void getResult_pass() {
    Referee referee = new Referee();
    Rewards actual = referee.getResults(ladder, playerNames, rewards);

    assertEquals("5000", actual.getRewards(0));
    assertEquals("꽝", actual.getRewards(1));
    assertEquals("3000", actual.getRewards(2));
    assertEquals("꽝", actual.getRewards(3));

    Ladder ladder2 = LadderFactory.createLadder(2, playerNames.size(), new OnlyBarLadderBarStatusDecider());
    Rewards actual2 = referee.getResults(ladder2, playerNames, rewards);

    assertEquals("꽝", actual2.getRewards(0));
    assertEquals("5000", actual2.getRewards(1));
    assertEquals("꽝", actual2.getRewards(2));
    assertEquals("3000", actual2.getRewards(3));
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