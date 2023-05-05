package ladder.domain;

import ladder.strategy.DirectionMoveStrategy;
import ladder.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

  private final MoveStrategy moveStrategy;
  private final List<LadderLine> ladderLines;

  public Ladder(int countOfUsers, int ladderHeight) {
    this.moveStrategy = new DirectionMoveStrategy();
    this.ladderLines = createLadderLines(countOfUsers, ladderHeight);
  }

  public List<LadderLine> unmodifiableLadderLines() {
    return Collections.unmodifiableList(ladderLines);
  }

  private List<LadderLine> createLadderLines(int countOfUsers, int ladderHeight) {
    List<LadderLine> ladderLineList = new ArrayList<>();

    IntStream.range(0, ladderHeight)
            .forEach((i) -> ladderLineList.add(LadderLine.createPoints(countOfUsers, moveStrategy)));

    return ladderLineList;
  }
}
