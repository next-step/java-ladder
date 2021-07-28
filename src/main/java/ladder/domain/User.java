package ladder.domain;

import java.util.Objects;

public class User {

    private Name name;
    private String gameResult;

    public User(String name,String gameResult){
        this(new Name(name));
        this.gameResult = gameResult;
    }

    public User(String name) {
        this(new Name(name));
    }

    public User(Name name) {
        this.name = name;
    }

    public String name() {
        return this.name.name();
    }

    public String gameResult(){
        return this.gameResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name.name(), user.name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.name());
    }
}
