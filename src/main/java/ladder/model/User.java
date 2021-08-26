package ladder.model;

public class User {
    private static final int NAME_LENGTH = 5;

    private final String userName;
    private String result;

    public User(String userName) {
        validName(userName);
        this.userName = userName;
    }

    public String nameInfo() {
        return userName;
    }

    public String resultInfo() {
        return result;
    }

    private void validName(String name) {
        if (name == null || name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void gameResult(String result) {
        this.result = result;
    }

}
