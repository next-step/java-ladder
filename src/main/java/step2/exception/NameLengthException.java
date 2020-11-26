package step2.exception;

public class NameLengthException extends IllegalArgumentException{
    public NameLengthException() {
        super("이름은 5글자까지 입니다.");
    }
}
