package nextstep.domain;

public class Player {

    public final Name name;

    public Player(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }
}
