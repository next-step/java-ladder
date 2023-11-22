package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.AxisX;
import nextstep.ladder.domain.wrapper.AxisY;
import nextstep.ladder.domain.wrapper.Name;

import java.util.Objects;

public class Player {

    private Name name;
    private AxisX axisX;
    private AxisY axisY;

    public Player(Name name, AxisX axisX, AxisY axisY) {
        this.name = name;
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public String name() {
        return this.name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(axisX, player.axisX) && Objects.equals(axisY, player.axisY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, axisX, axisY);
    }
}
