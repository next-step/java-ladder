package ladder.domain;

public class LadderLine {

  public static final String INVALID_LADDER_LINE_INPUT = "올바르지 않은 라인 길이를 입력하셨습니다. 입력한 높이: %s";

  public static final String LINE = "-";

  private final String line;

  public LadderLine(int lineSize) {
    validate(lineSize);
    this.line = LINE.repeat(lineSize);
  }

  public String print() {
    return line;
  }

  private void validate(int input) {
    if (input <= 0) {
      throw new IllegalArgumentException(String.format(INVALID_LADDER_LINE_INPUT, input));
    }
  }
}
