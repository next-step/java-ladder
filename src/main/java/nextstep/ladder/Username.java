package nextstep.ladder;

public class Username {
    private String username;

    private static final int MAX_USERNAME_LENGTH = 5;

    public Username(String username) {
        if (username.length() > MAX_USERNAME_LENGTH) {
            throw new IllegalArgumentException("사람 이름은 최대 5글자까지 입력 가능합니다.");
        }
        this.username = username;
    }

    public String getUsernameForPrint() {
        return String.format("%-6s", username);
    }
}
