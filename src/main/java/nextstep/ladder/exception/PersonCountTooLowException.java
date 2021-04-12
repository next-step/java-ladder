package nextstep.ladder.exception;

public class PersonCountTooLowException extends LadderException {

  public static final String PERSON_COUNT_TOO_LOW = "사람의 수가 너무 적습니다. 최소 2명이어야 합니다.";

  public PersonCountTooLowException() {
    super(PERSON_COUNT_TOO_LOW);
  }
}
