package ladder.domain.model;

import ladder.domain.model.strategy.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private List<Boolean> points = new ArrayList<>();


    public void connectLine(ConnectionStrategy connectionStrategy) {
        if (connectionStrategy.isConnection()) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
