package nextstep.ladder.entity.ladder;

import java.util.Optional;

public class FloorGenerator extends Floor {

    private final LinkGenerator linkGenerator;

    public FloorGenerator(LinkGenerator linkGenerator) {
        super();
        this.linkGenerator = linkGenerator;
    }

    public Floor create(int countOfPoints) {
        // 점 초기화
        Point point = initPoints(countOfPoints);
        // 점 연결
        createLinkRecursively(point);
        return new Floor(point, countOfPoints);
    }

    private Point initPoints(int countOfPoints) {

        Point startPoint = new Point();
        Point current = startPoint;
        Point next;

        for (int count = 2; count <= countOfPoints; count++) {
            next = new Point();
            current.next(next);
            current = next;
        }

        return startPoint;
    }

    private void createLinkRecursively(Point target) {
        Optional.ofNullable(target)
                .filter(Point::hasNext)
                .filter(point -> !point.isLinked())
                .ifPresent(this::link);

        if (target.hasNext()) {
            createLinkRecursively(target.getNext());
        }
    }

    private void link(Point point) {
        if (linkGenerator.isPossibleToLink()) {
            point.linkWithNext();
        }
    }

}

