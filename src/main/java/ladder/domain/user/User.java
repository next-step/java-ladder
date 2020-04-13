package ladder.domain.user;

public class User {

    String name;

    public User(String name) {
        lengthValidator(name);
        this.userName = name;
    }
    private void lengthValidator(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IndexOutOfBoundsException(LENGTH_EXCEPTION_MESSAGE);
        }
    }
