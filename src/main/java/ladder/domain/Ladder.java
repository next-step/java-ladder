package ladder.domain;

import ladder.strategy.DirectionMoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

  private final List<LadderLine> ladderLines;

  public Ladder(LadderLine ladderLine, int ladderHeight) {
    this.ladderLines = createLadderLines(ladderLine, ladderHeight);
  }

  public List<LadderLine> unmodifiableLadderLines() {
    return Collections.unmodifiableList(ladderLines);
  }

  private List<LadderLine> createLadderLines(LadderLine ladderLine, int ladderHeight) {
    List<LadderLine> ladderLineList = new ArrayList<>();

    IntStream.range(0, ladderHeight)
            .forEach((i) -> ladderLineList.add(ladderLine));

    return ladderLineList;
  }
}
