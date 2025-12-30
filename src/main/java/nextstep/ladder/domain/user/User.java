package nextstep.ladder.domain.user;


import java.util.Objects;

public class User {

    private final UserName name;

    public User(String name) {
        this.name = new UserName(name);
    }

    public UserName getName() {
        return name;
    }

    public String getNameValue() {
        return name.getName();
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
