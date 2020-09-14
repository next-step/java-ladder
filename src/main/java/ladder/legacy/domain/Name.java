package ladder.legacy.domain;

public class Name {
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public static Name of(String input) {
        if (input.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 최대 5글자까지만 부여할 수 있습니다.");
        }
        return new Name(input);
    }

    public boolean equals(String input) {
        return name.equals(input);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            return name.equals(((Name) obj).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
