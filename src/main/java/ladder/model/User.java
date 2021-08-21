package ladder.model;

public class User {
    private final String userName;

    public User(String userName) {
        validName(userName);
        this.userName = userName;
    }

    public String getName() {
        return userName;
    }

    private boolean validName(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
