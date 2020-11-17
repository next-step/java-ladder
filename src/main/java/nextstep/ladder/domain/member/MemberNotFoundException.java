package nextstep.ladder.domain.member;

public class MemberNotFoundException extends RuntimeException {
    private static final String MESSAGE = "해당 멤버를 찾을 수 없습니다.";

    public MemberNotFoundException() {
        super(MESSAGE);
    }
}
