package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

    public static Line createLine(int playerCount, LineStrategy lineStrategy) {
        List<Boolean> routes = new ArrayList<>();
        for (int i = 0; i < playerCount - 1; i++) {
            createRoute(lineStrategy, i, routes);
        }
        return new Line(routes);
    }

    private static void createRoute(LineStrategy lineStrategy, int i, List<Boolean> routes) {
        if (lineStrategy.isDrawable()) {
            addRouteUnderConnectedCondition(i, routes);
            return;
        }
        routes.add(false);
    }

    private static void addRouteUnderConnectedCondition(int i, List<Boolean> routes) {
        if (i == 0 || !routes.get(i - 1)) {
            routes.add(true);
            return;
        }
        routes.add(false);
    }
}
