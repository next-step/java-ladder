package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Name;

public class Player {

    private final Name name;
    private Coordinate coordinate;

    public Player(String name, Coordinate coordinate) {
        this.name = new Name(name);
        this.coordinate = coordinate;
    }

    public String name() {
        return this.name.toString();
    }

    public boolean isEqualCoordinate(Coordinate coordinate) {
        return this.coordinate.equals(coordinate);
    }

    public Player move(Bridges bridge) {
        coordinate = coordinate.findNextCoordinate(bridge);
        return this;
    }

    public boolean isEqualName(String name) {
        return name().equals(name);
    }
}
