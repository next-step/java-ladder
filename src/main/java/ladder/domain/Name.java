package ladder.domain;

public class Name {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자이하 이어야 합니다");
        }

        this.name = name;
    }

    public String name() {
        return name;
    }

    public int length() {
        return name.length();
    }
}
