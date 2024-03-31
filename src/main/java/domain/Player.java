package domain;

import java.util.List;
import java.util.Objects;

public class Player {
    private final Name name;
    private Position position;

    public static Player from(String name) {
        return new Player(name);
    }
    public static Player of(String name, Integer position) {
        return new Player(name, position);
    }

    public static Player of(Name name, Position position) {
        return new Player(name, position);
    }

    private Player(String name, Integer position) {
        this(Name.from(name), Position.valueOf(position));
    }

    private Player(String name) {
        this.name = Name.from(name);
        this.position = Position.valueOf(0);
    }

    private Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean hasPosition(int target) {
        return position.hasPosition(target);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public int getPlayedLastPosition(List<Line> lines) {
        return lines.stream()
                .map((line) -> line.checkPointDirection(this))
                .mapToInt(pointDirection -> {
                    position = position.move(pointDirection);
                    return position.getPosition();
                })
                .reduce((first, second) -> second)
                .orElse(position.getPosition());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
