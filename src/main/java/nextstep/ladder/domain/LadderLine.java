package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import nextstep.ladder.domain.model.Position;

public class LadderLine {

  private Map<Position, Position> movingRule = new HashMap<>();

  public LadderLine(int ladderWidth) {
    IntStream.range(0, ladderWidth)
        .forEach(this::drawLadderAt);

    if (movingRule.get(Position.at(ladderWidth - 1)) == Position.at(ladderWidth)) {
      movingRule.put(Position.at(ladderWidth - 1), Position.at(ladderWidth - 1));
    }
  }

  private void drawLadderAt(int position) {
    Position here = Position.at(position);
    if (hasLeftLeg(here)) {
      movingRule.put(here, here.getLeft());
      return;
    }

    movingRule.put(here, Position.at(position + (int) Math.round(Math.random())));
  }

  private boolean hasLeftLeg(Position position) {
    if (position.isFirst()) {
      return false;
    }

    return move(position.getLeft()) == position;
  }

  public int getWidth() {
    return movingRule.size();
  }

  public Position move(Position position) {
    if (!movingRule.containsKey(position)) {
      throw new IllegalArgumentException("위치가 사다리의 범위를 벗어났습니다.");
    }

    return movingRule.get(position);
  }
}
