package nextstep.ladder.domain;

import java.util.Objects;

public class Member {
    public static final int NAME_MAX_LENGTH = 5;
    public final String name;

    private Member(String name) {
        this.name = name;
    }

    public static Member of(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new NameLengthExceededException("참여자 이름은 " + NAME_MAX_LENGTH + "글자 이하여야 합니다.");
        }
        return new Member(name);
    }

    public String value() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Member)) {
            return false;
        }
        Member member = (Member) o;
        return Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
