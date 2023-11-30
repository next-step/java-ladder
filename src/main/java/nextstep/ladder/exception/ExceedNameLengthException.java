package nextstep.ladder.exception;

public class ExceedNameLengthException extends RuntimeException {
    private static final String MESSAGE = "참여자의 이름 길이가 초과되었습니다.";

    public ExceedNameLengthException(String person) {
        super(String.format(MESSAGE + "입력한 참여자의 길이는 %s자 입니다.", person.length()));
        System.out.println("person: " + person);
    }

}
