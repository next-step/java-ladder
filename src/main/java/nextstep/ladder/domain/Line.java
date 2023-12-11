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
