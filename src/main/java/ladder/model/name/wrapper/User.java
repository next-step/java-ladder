package ladder.model.name.wrapper;

import ladder.model.name.Name;

public class User {
    private final Name name;

    private User(String name){
        this.name = Name.createUserName(name);
    }

    public static User of(String name){
        return new User(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
