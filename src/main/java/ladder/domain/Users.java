package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Users {
    private List<Name> names;

    public Users(List<String> users) {
        this.names = new ArrayList<>();
        users.stream()
             .forEach(name -> this.names.add(new Name(name)));
    }

    public Users(String[] users) {
        this(Arrays.asList(users));
    }

    public Users(String users) {
        this(users.replace(" ", "").split(","));
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(names, users1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

}
