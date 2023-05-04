package nextstep.ladder.domain;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d 글자를 초과할 수 없습니다. name:" + name, MAX_NAME_LENGTH));
        }

        this.name = name;
    }

    public String name() {
        return name;
    }
}
