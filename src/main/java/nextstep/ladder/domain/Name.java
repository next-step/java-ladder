package nextstep.ladder.domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        checkNameRule(name);
        this.name = name;
    }

    private void checkNameRule(String name) {
        hasNullOrEmpty(name);
        overLengthRule(name);
    }

    private void hasNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

    private void overLengthRule(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
