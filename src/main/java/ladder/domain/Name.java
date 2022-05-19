package ladder.domain;

public class Name {
    private static final int MAX_LENGTH = 5;

    private final String name;

    private Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("참여자 이름은 최대 " + MAX_LENGTH + "글자까지만 입력가능합니다.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("참여자 이름이 존재하지 않습니다.");
        }
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }
}
