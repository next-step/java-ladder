package nextstep.ladder.exception;

public class LadderHeightTooLowException extends LadderException {

  public static final String LADDER_HEIGHT_TOO_LOW = "사다리의 높이는 최소 1이상이어야 합니다.";

  public LadderHeightTooLowException() {
    super(LADDER_HEIGHT_TOO_LOW);
  }
}
