package ladder.domain.ladder.ladder;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.ladder.line.HorizontalLadderLine;
import ladder.domain.ladder.line.point.LinePoint;
import ladder.domain.player.Player;

public class Ladder {

  private final List<HorizontalLadderLine> horizontalLines;

  public Ladder(List<HorizontalLadderLine> ladderLines) {
    this.horizontalLines = ladderLines.stream()
        .map(HorizontalLadderLine::freezeLine)
        .collect(Collectors.toUnmodifiableList());
  }

  public List<HorizontalLadderLine> getHorizontalLines() {
    return horizontalLines;
  }

  public LinePoint getPointAt (int height, int point) {
    return this.horizontalLines.get(height)
        .getPointAt(point);
  }

  public int getLadderHeight() {
    return this.horizontalLines.size();
  }
}
