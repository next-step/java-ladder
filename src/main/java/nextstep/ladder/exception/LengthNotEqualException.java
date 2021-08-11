package nextstep.ladder.exception;

public class LengthNotEqualException extends IllegalArgumentException{

    public LengthNotEqualException() {
        super("사람과 당첨 결과의 수는 같아야 합니다.");
    }
}
