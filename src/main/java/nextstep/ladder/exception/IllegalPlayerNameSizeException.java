package nextstep.ladder.exception;

public class IllegalPlayerNameSizeException extends RuntimeException {
    public IllegalPlayerNameSizeException(String name) {
        super("플레이어 이름은 최대 5글자까지 부여할 수 있습니다. input==" + name);
    }
}
