package ladder.domain.strtegy;

import ladder.domain.LadderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BooleanRandomLineGenerator implements LineGenerateStrategy {

  public static final String INVALID_LADDER_LINE_INPUT = "올바르지 않은 라인 길이를 입력하셨습니다. 입력한 높이: %s";

  public static final int START_INDEX = 0;
  private static final Random RANDOM = new Random();

  @Override
  public LadderLine generate(int size) {
    validate(size);
    List<Boolean> result = new ArrayList<>();
    generateLines(result, START_INDEX, size);
    return new LadderLine(result);
  }

  private void validate(int input) {
    if (input <= 0) {
      throw new IllegalArgumentException(String.format(INVALID_LADDER_LINE_INPUT, input));
    }
  }

  private void generateLines(List<Boolean> result, int index, int size) {
    if (index == size) {
      return;
    }
    boolean beforeValue = getBeforeValue(result, index);
    result.add(decideNextValue(beforeValue));
    generateLines(result, index + 1, size);
  }

  private boolean getBeforeValue(List<Boolean> result, int index) {
    if (index == START_INDEX) {
      return false;
    }
    return result.get(index - 1);
  }

  private boolean decideNextValue(boolean beforeValue) {
    // 연속적인 라인이 생기지 않도록, 이전이 true면 false를 할당
    if (Boolean.TRUE.equals(beforeValue)) {
      return false;
    }
    return RANDOM.nextBoolean();
  }
}
