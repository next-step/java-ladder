package ladder.model;

public class User {
    private static final int NAME_LENGTH = 5;
    private final String userName;

    public User(String userName) {
        validName(userName);
        this.userName = userName;
    }

    public String getName() {
        return userName;
    }

    private void validName(String name) {
        if (name == null || name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
