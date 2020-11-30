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

    public Floor getFirstFloor() {
        return firstFloor;
    }
}
