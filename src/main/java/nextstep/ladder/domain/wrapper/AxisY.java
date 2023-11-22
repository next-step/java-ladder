package nextstep.ladder.domain.wrapper;

import java.util.Objects;

public class AxisY {

    private int position;

    public AxisY(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxisY axisY = (AxisY) o;
        return position == axisY.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
