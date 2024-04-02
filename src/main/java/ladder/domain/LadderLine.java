package ladder.domain;

import java.util.List;

public class LadderLine {

  public static final String INVALID_LADDER_LINE_RULE = "사다리 라인은 연속적일 수 없습니다. 입력 값: %s";

  private final List<Boolean> lines;

  public LadderLine(List<Boolean> lines) {
    validate(lines);
    this.lines = lines;
  }

  public int size() {
    return lines.size();
  }

  public Boolean isTrue(int index) {
    return lines.get(index);
  }

  private void validate(List<Boolean> lines) {
    int nowTrueIndex = -100;
    for (int index = 0; index < lines.size(); index++) {
      if (lines.get(index) && index - nowTrueIndex == 1) {
        throw new IllegalArgumentException(String.format(INVALID_LADDER_LINE_RULE, lines));
      }

      if (lines.get(index)) {
        nowTrueIndex = index;
      }
    }
  }
}
