package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewLadder {

  private static final int START_INDEX = 0;
  private static final int FIRST_LINE_POINT = 0;
  private static final int SECOND_LINE_POINT = 1;
  private static final String VALIDATE_MESSAGE = "플레이어는 %d와 %d 사이에 위치해야 합니다.";

  private final List<LadderLine> lines;

  public NewLadder(List<LadderLine> lines) {
    this.lines = lines;
  }

  public static NewLadder init(Length width, Length height) {
    List<LadderLine> createdLines = new ArrayList<>();
    for (int i = START_INDEX; i < height.getValue(); i++) {
      createdLines.add(LadderLine.init(width.getValue()));
    }
    return new NewLadder(createdLines);
  }

  public int getWidth() {
    return lines.get(START_INDEX).size();
  }

  public int getHeight() {
    return lines.size();
  }

  private int lastIndex() {
    return getWidth() - 1;
  }

  public List<LadderLine> getLines() {
    return Collections.unmodifiableList(lines);
  }

  public int move(int playerIndex) {
    validateIndex(playerIndex);
    int nextIndex = lines.get(FIRST_LINE_POINT).move(playerIndex);
    for (int i = SECOND_LINE_POINT; i < lines.size(); i++) {
      nextIndex = lines.get(i).move(nextIndex);
    }
    return nextIndex;
  }

  private void validateIndex(int playerIndex) {
    if (playerIndex < START_INDEX || playerIndex > lastIndex()) {
      throw new IllegalArgumentException(
          String.format(VALIDATE_MESSAGE, START_INDEX, lastIndex())
      );
    }
  }
}
