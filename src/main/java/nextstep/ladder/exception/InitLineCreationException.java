package nextstep.ladder.exception;

public class InitLineCreationException extends IllegalArgumentException{
    public InitLineCreationException() {
        super("첫 사다리 변환이 되지를 않았습니다. INIT_LINE을 확인해주세요.");
    }
}
