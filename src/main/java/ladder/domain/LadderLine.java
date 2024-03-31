package ladder.domain;

import java.util.List;

public class LadderLine {

  public static final String INVALID_LADDER_LINE_RULE = "사다리 라인은 연속적일 수 없습니다. 입력 값: %s";

  public static final String LINE_MARK = "-";
  public static final String EMPTY_MARK = " ";
  public static final Integer LINE_SIZE = 5;  // 5개는 고정인 것 같은데, 요구사항 잘못 이해했는지 체크
  public static final String PRINT_LINE = LINE_MARK.repeat(LINE_SIZE);
  public static final String EMPTY_LINE = EMPTY_MARK.repeat(LINE_SIZE);

  private final List<Boolean> lines;

  public LadderLine(List<Boolean> lines) {
    validate(lines);
    this.lines = lines;
  }

  public String printLine(int index) {
    if (Boolean.TRUE.equals(lines.get(index))) {
      return PRINT_LINE;
    }
    return EMPTY_LINE;
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
