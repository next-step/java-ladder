package ladder.domain.user;

public class User {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String LENGTH_EXCEPTION_MESSAGE = "이름이 길어요";

    private final String userName;

    public User(String name) {
        lengthValidator(name);
        this.userName = name;
    }
    private void lengthValidator(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IndexOutOfBoundsException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public String userName() {
        return userName;
    }

    public User user() {
        return this;
    }
}
