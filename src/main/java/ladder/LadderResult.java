package ladder;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class LadderResult {

  private static final String RESULTS_DELIMITER = ",";
  private static final int MINIMUM_RESULTS_COUNT = 2;
  private static final int DEFAULT_RESULT_FORMAT_LENGTH = 6;
  private static final int RESULT_LIMIT_LENGTH = 5;
  private static final String RESULT_BLANK_SYMBOL = " ";
  private static final String JOINING_SYMBOL = "";

  List<String> ladderResult;

  public LadderResult(String results, int playerCount) {
    if (isBlank(results)) {
      throw new IllegalArgumentException("실행결과를 입력하세요");
    }
    ladderResult = initLadderResult(results);
    if (!isSamePlayerCount(playerCount)) {
      throw new IllegalArgumentException("참여할 사람수와 실행결과 수는 같아야 합니다.");
    }
  }

  private boolean isBlank(String results) {
    return results == null || "".equals(results.trim());
  }

  private List<String> initLadderResult(String results) {
    String[] splitResults = splitResults(results);
    checkResultCount(splitResults);
    return Arrays.stream(splitResults)
        .collect(toList());
  }

  private String[] splitResults(String playersName) {
    return playersName.split(RESULTS_DELIMITER);
  }

  private void checkResultCount(String[] splitNames) {
    if (splitNames.length < MINIMUM_RESULTS_COUNT) {
      throw new IllegalArgumentException("실행결과 는 최소 2개입니다.");
    }
  }

  private String formatResult(String result) {
    if (isGreater(result)) {
      return result;
    }
    return result + addBlank(DEFAULT_RESULT_FORMAT_LENGTH - result.length());
  }

  private boolean isGreater(String result) {
    return result.length() >= RESULT_LIMIT_LENGTH;
  }

  private String addBlank(int length) {
    StringBuffer blankBuffer = new StringBuffer();
    for (int i = 0; i < length; i++) {
      blankBuffer.append(RESULT_BLANK_SYMBOL);
    }
    return blankBuffer.toString();
  }

  public boolean isSamePlayerCount(int count) {
    return ladderResult.size() == count;
  }

  public String getLadderResult(int resultIndex) {
    return ladderResult.get(resultIndex);
  }

  @Override
  public String toString() {
    return ladderResult.stream()
        .map(result -> formatResult(result))
        .collect(joining(JOINING_SYMBOL));
  }

}
