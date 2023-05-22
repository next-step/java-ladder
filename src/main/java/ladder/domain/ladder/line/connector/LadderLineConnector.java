package ladder.domain.ladder.line.connector;

import ladder.domain.ladder.line.HorizontalLadderLine;

public interface LadderLineConnector {
  HorizontalLadderLine connectNextPoint(HorizontalLadderLine line, int linePointIdx);
}
