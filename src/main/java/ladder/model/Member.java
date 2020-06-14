package ladder.model;

import java.util.Objects;

public class Member {

    private static final String EMPTY_STRING = "";
    private static final int MEMBER_NAME_LENGTH_LIMIT = 5;
    private final String name;

    public Member(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateNullOrEmpty(name);
        validateLengthLimit(name);
    }

    private void validateNullOrEmpty(final String name) {
        if (Objects.isNull(name) || EMPTY_STRING.equals(name.trim())) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람의 이름은 빈 공백이 될 수 없습니다.");
        }
    }

    private void validateLengthLimit(final String name) {
        if (name.length() > MEMBER_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람의 이름은 최대 5 글자 입니다.");
        }
    }

    public static Member create(final String name) {
        return new Member(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
