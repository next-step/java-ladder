package ladder.domain;

import java.util.List;

import ladder.exception.LineInvalidException;

public class Line {
    private final List<Boolean> links;

    public Line(List<Boolean> links) {
        validateLinks(links);
        this.links = links;
    }

    private void validateLinks(List<Boolean> links) {
        if (links.isEmpty()) {
            throw new LineInvalidException();
        }

        for (int i = 0; i < links.size() - 1; i++) {
            validateLink(links.get(i), links.get(i + 1));
        }
    }

    private static void validateLink(boolean prevPoint, boolean currentPoint) {
        if (prevPoint && currentPoint) {
            throw new LineInvalidException();
        }
    }

    public List<Boolean> getLinks() {
        return links;
    }

    public List<Point> getPoints() {
        return PointFactory.createPointsFromLinks(links);
    }
}
