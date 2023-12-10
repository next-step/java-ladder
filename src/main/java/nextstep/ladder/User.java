package nextstep.ladder;

public class User {

    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    public User(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }
}
