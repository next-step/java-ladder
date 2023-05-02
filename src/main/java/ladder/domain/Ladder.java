package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    for (int i = 0; i < ladderHeight; i++) {
      ladderLineList.add(LadderLine.createPoints(countOfUsers, moveStrategy));
    }

    return ladderLineList;
  }
}
