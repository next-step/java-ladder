package ladder.domain.ladder.ladder;

import java.util.Collections;
import java.util.List;
import ladder.domain.ladder.line.HorizontalLadderLine;
import ladder.domain.ladder.line.point.LinePoint;
import ladder.domain.player.Player;

public class Ladder {

  private final List<HorizontalLadderLine> horizontalLines;

  public Ladder(List<HorizontalLadderLine> ladderLines) {
    this.horizontalLines = Collections.unmodifiableList(ladderLines);
  }

  public List<HorizontalLadderLine> getHorizontalLines() {
    return horizontalLines;
  }

  public LinePoint getPointAt (Player player) {
    return this.horizontalLines.get(player.getCurrentHeight() - 1)
        .getPointAt(player.getCurrentLine());
  }

  public int getLadderHeight() {
    return this.horizontalLines.size();
  }
}
