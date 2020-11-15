package nextstep.ladder.domain.member;

public class InvalidMemberNameException extends RuntimeException {
    private static final String MESSAGE = "참여자 이름은 1자 이상 5자 이하로 입력해주세요.";

    public InvalidMemberNameException() {
        super(MESSAGE);
    }
}
