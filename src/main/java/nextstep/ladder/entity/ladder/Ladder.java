package nextstep.ladder.entity.ladder;

public class Ladder {

    private final Floor firstFloor;
    private int totalFloorsCount;

    private Ladder(Floor firstFloor, int totalFloorsCount) {
        this.firstFloor = firstFloor;
        this.totalFloorsCount = totalFloorsCount;
    }

    public static Ladder create(LadderConfiguration ladderConfiguration, LinkGenerator linkGenerator) {

        FloorGenerator floorGenerator = new FloorGenerator(linkGenerator);

        Floor firstFloor = floorGenerator.create(ladderConfiguration.getCountOfLines());

        Floor current = firstFloor;
        Floor next;

        for (int count = 2; count <= ladderConfiguration.getCountOfFloors(); count++) {
            next = floorGenerator.create(ladderConfiguration.getCountOfLines());
            current.next(next);
            current = next;
        }

        return new Ladder(firstFloor, ladderConfiguration.getCountOfFloors());
    }

    public Floor getFirstFloor() {
        return firstFloor;
    }
}
