package nextstep.ladder.exception;

public class PersonLengthException extends RuntimeException {
    private static final String MESSAGE = "참여할 사람의 이름은 5자 이하로 입력하세요.";

    public PersonLengthException(String person) {
        super(MESSAGE);
        System.out.println("person: " + person);
    }

}
