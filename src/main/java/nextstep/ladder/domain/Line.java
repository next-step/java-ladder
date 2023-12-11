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
}
