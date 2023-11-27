package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Name;

public class Player {

    private final Name name;
    private Position position;

    public Player(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String name() {
        return this.name.toString();
    }

    public boolean isEqualCoordinate(Position position) {
        return this.position.equals(position);
    }

    public Player move(Bridges bridge) {
        position = position.findNextCoordinate(bridge);
        return this;
    }

    public boolean isEqualName(String name) {
        return name().equals(name);
    }
}
