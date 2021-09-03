package newladder.model;


import java.util.Objects;

public class User {
    private static final int NAME_LENGTH = 5;

    private final String userName;

    public User(String userName) {
        validName(userName);
        this.userName = userName;
    }

    public String nameInfo() {
        return userName;
    }

    private void validName(String name) {
        if (name == null || name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public Boolean compareName(String name) {
        return name.equals(this.userName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return compareName(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
