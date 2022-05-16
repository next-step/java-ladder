package ladder.domain;

public class Name {
    private final String name;

    public Name(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값을 입력 할 수 없습니다.");
        }

        if (name.length() < 1  || name.length() > 6) {
            throw new IllegalArgumentException("이름은 1 ~ 5 글자만 허용됩니다.");
        }

        this.name = name;
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
