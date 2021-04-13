package nextstep.ladder.exception;

public class SizeNotMatchingException extends LadderException {

  public static final String PERSON_COUNT_RESULT_COUNT_NOT_MATCHING = "사람의 수와 결과의 수는 같아야 합니다.";

  public SizeNotMatchingException() {
    super(PERSON_COUNT_RESULT_COUNT_NOT_MATCHING);
  }
}
