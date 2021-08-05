package nextstep.ladder;

public class InputNullException extends IllegalArgumentException{
    public InputNullException() {
        super("이름을 공백으로 할 수 없습니다.");
    }
}
