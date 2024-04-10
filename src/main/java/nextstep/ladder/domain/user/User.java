package nextstep.ladder.domain.user;

public class User {

    private final UserName name;

    private User(UserName name) {
        this.name = name;
    }

    public static User of(String name) {
        return new User(UserName.of(name));
    }

    public String getName() {
        return name.getName();
    }

}
