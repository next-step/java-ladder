package nextstep.ladder;

import java.util.Objects;

public class Username {
    private static final int MAX_USERNAME_LENGTH = 5;
    private String username;

    public Username(String username) {
        if (username.length() > MAX_USERNAME_LENGTH) {
            throw new IllegalArgumentException("사람 이름은 최대 5글자까지 입력 가능합니다.");
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getUsernameForPrint() {
        return String.format("%-6s", username);
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
}
