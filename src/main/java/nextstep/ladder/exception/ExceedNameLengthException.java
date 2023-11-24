package nextstep.ladder.exception;

public class ExceedNameLengthException extends RuntimeException {
    private static final String MESSAGE = "참여자의 이름은 5자 이하로 입력하세요.";

    public ExceedNameLengthException(String person) {
        super(MESSAGE);
        System.out.println("person: " + person);
    }

}
