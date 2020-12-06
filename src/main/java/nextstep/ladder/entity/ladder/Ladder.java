package nextstep.ladder.entity.ladder;

public class Ladder {

    private final Floor firstFloor;

    private Ladder(Floor firstFloor) {
        this.firstFloor = firstFloor;
    }

    public static Ladder create(LadderHeight ladderHeight, FloorGenerator floorGenerator) {

        Floor firstFloor = floorGenerator.create();

        Floor current = firstFloor;
        Floor next;

        for (int count = 2; count <= ladderHeight.getHeight(); count++) {
            next = floorGenerator.create();
            current.next(next);
            current = next;
        }

        return new Ladder(firstFloor);
    }

    public int goDown(int startPosition) {
        return goDownRecursively(firstFloor, firstFloor.moveTo(startPosition))
                .getPosition();
    }

    private Point goDownRecursively(Floor floor, Point point) {

        if (!floor.hasNext()) {
            return getPointOnLastFloor(point);
        }

        int nextPosition = point.isLinked() ? point.getLinkPoint().getPosition() : point.getPosition();
        Floor nextFloor = floor.getNextFloor();
        Point nextPoint = nextFloor.moveTo(nextPosition);

        return goDownRecursively(nextFloor, nextPoint);
    }

    private Point getPointOnLastFloor(Point point) {
        if (point.isLinked()) {
            return point.getLinkPoint();
        }
        return point;
    }

    public Floor getFirstFloor() {
        return firstFloor;
    }


}
