package nextstep.ladder.domain;

import java.util.Random;

public class RandomLadderBarStatusDecider implements LadderBarStatusDecider {

  @Override
  public LadderBarStatus decide(LadderBarStatus ladderBarStatus) {
    if (!ladderBarStatus.isEmpty()) {
      return LadderBarStatus.EMPTY;
    }

    return new Random().nextInt(2) == 0 ? LadderBarStatus.EMPTY : LadderBarStatus.BAR;
  }
}
