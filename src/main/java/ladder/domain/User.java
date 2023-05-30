package ladder.domain;

import ladder.DoNotCreateUser;

public class User {

    private String name;
    public User(String name) {
        if (isOverLength(name)) {
            throw new DoNotCreateUser("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    private boolean isOverLength(String name) {
        return name.length() > 5;
    }
}
