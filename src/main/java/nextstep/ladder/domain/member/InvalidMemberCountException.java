package nextstep.ladder.domain.member;

public class InvalidMemberCountException extends RuntimeException {
    private static final String MESSAGE = "2명 이상의 참여자로만 사다리 생성이 가능합니다.";

    public InvalidMemberCountException() {
        super(MESSAGE);
    }
}
