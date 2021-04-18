package nextstep.ladder.exception;

import nextstep.ladder.domain.Result;

public class OverResultLengthLimitException extends LadderException {

  public static final String OVER_RESULT_LENGTH_LIMIT = "결과는 최대 " + Result.MAX_LENGTH + "글자입니다.";

  public OverResultLengthLimitException() {
    super(OVER_RESULT_LENGTH_LIMIT);
  }
}
