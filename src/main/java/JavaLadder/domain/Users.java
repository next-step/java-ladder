package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Users {
    private static final String REGEX =",";
    private List<User> users = new ArrayList<>();

    public Users(String input) {
        String[] splitInputValue = input.split(REGEX);
        for (int i = 0; i < splitInputValue.length; i++) {
            User user = new User(splitInputValue[i]);
            this.users.add(user);
        }
    }

    public String getName(int index) {
        return users.get(index).getName();
    }

    public int size() {
        return users.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
