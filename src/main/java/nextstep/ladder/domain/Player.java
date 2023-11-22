package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Width;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Name;

import java.util.Objects;

public class Player {

    private Name name;
    private Width width;
    private Height height;

    public Player(Name name, Width width, Height height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String name() {
        return this.name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(width, player.width) && Objects.equals(height, player.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, width, height);
    }
}
