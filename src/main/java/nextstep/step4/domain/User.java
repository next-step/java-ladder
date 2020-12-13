package nextstep.step4.domain;

public class User {

    private final String name;

    private User(String name) {
        this.name = name;
    }

    public static User of(String name) {
        return new User(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
