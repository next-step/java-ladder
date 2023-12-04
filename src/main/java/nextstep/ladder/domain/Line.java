package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> routes = new ArrayList<>();

    public Line(int playerCount, LineStrategy lineStrategy) {
        for (int i = 0; i < playerCount - 1; i++) {
            createRoute(lineStrategy, i);
        }
    }

    private void createRoute(LineStrategy lineStrategy, int i) {
        if (lineStrategy.isDrawable()) {
            addRouteUnderConnectedCondition(i);
            return;
        }
        routes.add(false);
    }

    private void addRouteUnderConnectedCondition(int i) {
        if (i == 0 || !routes.get(i - 1)) {
            routes.add(true);
            return;
        }
        routes.add(false);
    }

    public long routeCount() {
        return this.routes.stream().filter(r -> r).count();
    }
}
