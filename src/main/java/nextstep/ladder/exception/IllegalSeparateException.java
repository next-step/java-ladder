package nextstep.ladder.exception;

public class IllegalSeparateException extends RuntimeException {
    public IllegalSeparateException(String names) {
        super("이를음 쉼표(,) 를 기준으로 입력해야 합니다. input===" + names);
    }
}
