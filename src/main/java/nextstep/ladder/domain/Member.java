package nextstep.ladder.domain;

import java.util.Objects;

public class Member {
    private static final int MAX_MEMBER_NAME_LENGTH = 5;

    private final String name;

    public Member(String name) {
        validationMember(name);
        this.name = name;
    }

    private void validationMember(String name){
        if(Objects.isNull(name) || name.length() == 0) {
            throw new IllegalArgumentException("참가자명을 입력하세요.");
        }

        if(name.length() > MAX_MEMBER_NAME_LENGTH) {
            throw new IllegalArgumentException("5글자를 초과하였습니다.");
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
