package nextstep.ladder.exception;

import nextstep.ladder.Name;

public class OverNameLengthLimitException extends LadderException {

  public static final String OVER_NAME_LENGTH_LIMIT = "이름은 최대 " + Name.MAX_LENGTH + "글자입니다.";

  public OverNameLengthLimitException() {
    super(OVER_NAME_LENGTH_LIMIT);
  }
}
