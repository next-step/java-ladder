package nextstep.ladder.domain;

import java.util.Objects;

public class Member {
    private static final int MAX_MEMBER_NAME_LENGTH = 5;
    private static final String EXCEPTION_MESSAGE_MEMBER_NAME = "참가자명을 입력하세요.";
    private static final String EXCEPTION_MESSAGE_MEMBER_NAME_LENGTH = "5글자를 초과하였습니다.";

    private final String name;

    public Member(String name) {
        validateMember(name);
        this.name = name;
    }

    private void validateMember(String name) {
        if (Objects.isNull(name) || name.length() == 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MEMBER_NAME);
        }

        if (name.length() > MAX_MEMBER_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MEMBER_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
