package nextstep.ladder.domain;

public class Name {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("사람 이름은 최대 5글자까지 부여할 수 있습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
