package ladder.domain.player;

public class Name {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null 일 수 없습니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("이름의 길이(%s)는 %s를 넘을 수 없습니다.", name.length(), MAX_LENGTH));
        }
    }

    public static Name valueOf(String name) {
        return new Name(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
