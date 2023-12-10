package nextstep.ladder.domain;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 최대 %d 길이까지 부여할 수 있습니다.", MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
