package nextstep.ladder.exception;

public class MisMatchNameException extends RuntimeException {
    private static final String MESSAGE = "%s 이름을 가진 사람은 존재 하지 않습니다.";

    public MisMatchNameException(String name) {
        super(String.format(MESSAGE, name));
        System.out.println("name: " + name);
    }

}
