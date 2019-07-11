package ladder.domain.user;

import java.util.Objects;

public class Username {
    private static final String ALL_USERNAME = "all";

    private String username;

    private Username(String username) {
        validate(username);
        this.username = username;
    }

    private void validate(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Invalid username");
        }
    }

    public static Username of(String username) {
        return new Username(username);
    }

    public int length() {
        return username.length();
    }

    public boolean isAllUser() {
        return ALL_USERNAME.equals(username);
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Username username1 = (Username) o;
        return Objects.equals(username, username1.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return username;
    }
}
