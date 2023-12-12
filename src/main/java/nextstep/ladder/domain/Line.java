package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private final List<Boolean> routes;

    public Line(List<Boolean> routes) {
        this.routes = routes;
    }

    public long routeCount() {
        return this.routes.stream().filter(r -> r).count();
    }

    public List<Boolean> routes() {
        return routes;
    }

    public int proceedLine(int startIndex) {
        if (startIndex != routes.size() && routes.get(startIndex)) {
            return proceedRight(startIndex);
        }
        if (startIndex != 0 && routes.get(startIndex - 1)) {
            return proceedLeft(startIndex);
        }
        return startIndex;
    }

    private int proceedLeft(int startIndex) {
        for (int i = startIndex - 1; i >= 0; i--) {
            if (!routes.get(i)) {
                return i + 1;
            }
        }
        return 0;
    }

    private int proceedRight(int startIndex) {
        for (int i = startIndex; i < routes.size(); i++) {
            if (!routes.get(i)) {
                return i;
            }
        }
        return routes.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Boolean route : this.routes()) {
            result.append("|");
            if (route) {
                result.append("-----");
                continue;
            }
            result.append("     ");
        }
        result.append("|\n");

        return result.toString();
    }
}
