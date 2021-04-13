package nextstep.ladder.exception;

public class EmptyStringNotAllowedException extends LadderException {

  public static final String EMPTY_STRING_NOT_ALLOWED = "빈 문자열이 입력되었습니다. 최소 1글자 이상 입력해주세요.";

  public EmptyStringNotAllowedException() {
    super(EMPTY_STRING_NOT_ALLOWED);
  }
}
