package ladder.domain;

public class Name {
    private String name;
    private static final int LIMIT_MAX_LENGTH = 5;
    private static final int LIMIT_MIN_LENGTH = 0;

    public Name(String name) {
        this.name = name;
        checkLength();
    }

    public String name() {
        return this.name;
    }

    private void checkLength() {
        if (name.length() > LIMIT_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }

        if (name == null || name.length() <= LIMIT_MIN_LENGTH) {
            throw new IllegalArgumentException("이름은 빈칸을 넣을 수 없습니다.");
        }
    }
}
