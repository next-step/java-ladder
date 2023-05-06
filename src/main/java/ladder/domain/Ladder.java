package ladder.domain;

import ladder.strategy.DirectionMoveStrategy;
import ladder.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

  private final List<LadderLine> ladderLines;
  private final LadderRewards ladderRewards;

  public Ladder(int countOfUsers, int ladderHeight, LadderRewards ladderRewards) {
    this.ladderLines = createLadderLines(countOfUsers, ladderHeight);
    this.ladderRewards = ladderRewards;
  }

  public List<LadderLine> unmodifiableLadderLines() {
    return Collections.unmodifiableList(ladderLines);
  }

  public List<LadderReward> unmodifiableLadderRewards() {
    return ladderRewards.ladderRewards();
  }

  private List<LadderLine> createLadderLines(int countOfUsers, int ladderHeight) {
    List<LadderLine> ladderLineList = new ArrayList<>();

    IntStream.range(0, ladderHeight)
            .forEach((i) -> ladderLineList.add(LadderLine.createPoints(countOfUsers, new DirectionMoveStrategy())));

    return ladderLineList;
  }
}
