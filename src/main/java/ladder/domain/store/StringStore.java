package ladder.domain.store;

import java.util.Arrays;
import java.util.List;
import ladder.util.InputValidator;

public class StringStore {

  private static final String REGEX = ",";

  protected static List<String> stringToList(String inputText) {
    return Arrays.asList(splitString(inputText));
  }

  protected static String[] splitString(String inputText) {
    return inputText.split(REGEX);
  }

  protected static void validateInputText(String inputText) {
    if (InputValidator.isEmptyOrBlank(inputText)) {
      throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
    }
  }
}
