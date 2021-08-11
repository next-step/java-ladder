package nextstep.ladder.exception;

public class NotExistPersonException extends IllegalArgumentException{

    public NotExistPersonException() {
        super("해당하는 사람이 없습니다.");
    }
}
