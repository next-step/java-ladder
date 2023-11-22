package nextstep.ladder.domain.wrapper;

import java.util.Objects;

public class AxisX {

    private int position;

    public AxisX(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxisX axisX = (AxisX) o;
        return position == axisX.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
