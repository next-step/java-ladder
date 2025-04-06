package nextstep.ladder.domain;

import java.util.List;

public class Row {

    private final List<Junction> junctions;

    public Row(List<Junction> junctions) {
        this.junctions = junctions;
    }

    public void applyRungs(RungStrategy rungStrategy) {
        for (int i = 0; i < junctions.size() - 1; i++) {
            Junction junction = junctions.get(i);
            Junction rightJunction = junctions.get(i + 1);
            rungStrategy.apply(junction, rightJunction);
        }
    }

    public Junction getJunction(int index) {
        return junctions.get(index);
    }
}
