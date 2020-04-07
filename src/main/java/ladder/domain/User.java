package ladder.domain;

import lombok.Getter;

public class User {
    @Getter
    private String name;
    @Getter
    private String reward;

    public User(String name, String reward) {
        this.name = name;
        this.reward = reward;
    }

    public boolean equalsUserName(String userName) {
        return this.name.equals(userName);
    }
}
