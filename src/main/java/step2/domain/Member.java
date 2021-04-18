package step2.domain;

import step2.util.StringUtils;

import java.util.Objects;

public class Member {
    private final static int NAME_MAX_LENGTH = 5;
    private final static String NAME_MAX_LENGTH_IS_FIVE_EXCEPTION_MESSAGE = "이름은 5자까지 가능합니다.";
    public final static String INPUT_NAME_EXCEPTION_MESSAGE = "이름은 공백이 될 수 없습니다.";
    private final static String ALL_MEMBER = "all";

    private final String name;

    public Member(String name) {
        validationName(name);
        this.name = name;
    }

    private void validationName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException(INPUT_NAME_EXCEPTION_MESSAGE);
        }

        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_MAX_LENGTH_IS_FIVE_EXCEPTION_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
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

    public boolean isAll() {
        return ALL_MEMBER.equals(name);
    }
}
