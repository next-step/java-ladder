package ladder.ladderexceptions;


public class InvalidUserNameException extends IllegalArgumentException {
    public InvalidUserNameException() {
        super("잘못된 형식의 유저 이름입니다.");
    }
}
