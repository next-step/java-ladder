package nextstep.ladder.domain.member;

import java.util.Objects;

public final class MemberName {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public MemberName(String name) {
        this.name = name;
    }

    public static MemberName of(String text) {
        validateNameLength(text.length());
        return new MemberName(text);
    }

    private static void validateNameLength(int nameLength) {
        if (nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH) {
            throw new InvalidMemberNameException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberName that = (MemberName) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
