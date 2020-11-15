package nextstep.ladder.domain.member;

public class Member {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Member(String name) {
        this.name = name;
    }

    public static Member of(String name) {
        validateNameLength(name.length());
        return new Member(name);
    }

    private static void validateNameLength(int nameLength) {
        if (nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH) {
            throw new InvalidMemberNameException();
        }
    }

    public String getName() {
        return name;
    }
}
