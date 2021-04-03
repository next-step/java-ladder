package ladder.domain;

import java.util.regex.Pattern;

public class Name {
  private final String name;
  private final static String INVALID_PATTERN_REGEX = "^[가-힣a-zA-Z]*$";
  private final static String INVALID_NAME = "영어와 한글만 입력하세요.";

  public Name(String name) {
    this.name = name;
    validateName();
  }

  private void validateName() {
    if(!Pattern.matches(INVALID_PATTERN_REGEX,name)) {
      throw new IllegalArgumentException(INVALID_NAME);
    }
  }

  public String name() {
    return name;
  }
}
