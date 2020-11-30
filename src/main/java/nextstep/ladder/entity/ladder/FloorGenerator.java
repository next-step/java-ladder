package nextstep.ladder.entity.ladder;

import java.util.Optional;

public class FloorGenerator {

    private final LinkGenerator linkGenerator;
    private final LadderLine ladderLine;

    public FloorGenerator(LinkGenerator linkGenerator, LadderLine ladderLine) {
        this.linkGenerator = linkGenerator;
        this.ladderLine = ladderLine;
    }

    public Floor create() {
        // 점 초기화
        Point point = initPoints();
        // 점 연결
        createLinkRecursively(point);
        return new Floor(point);
    }

    private Point initPoints() {

        Point startPoint = new Point();
        Point current = startPoint;
        Point next;

        for (int count = 2; ladderLine.more(count); count++) {
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

