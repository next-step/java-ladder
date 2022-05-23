package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Player {
    private final String name;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("name should be less than 5, but: " + name.length());
        }
        this.name = name;
    }

    public static Players parse(String line) {
        return new Players(Arrays.stream(line.split("\\s*,\\s*"))
                .map(Player::new)
                .collect(Collectors.toList()));
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

    public void draw() {
        System.out.print(String.format("%-6s", this.name));
    }
}
