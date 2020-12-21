package nextstep.ladder.domain;

import nextstep.ladder.domain.floor.FloorFactory;
import nextstep.ladder.domain.floor.Floors;
import nextstep.ladder.domain.floor.Position;

import java.util.stream.IntStream;

public class Ladder {

    private final Members members;
    private final Results results;
    private final Floors floors;

    public Ladder(Members members, Results results, Height height) {
        this.members = members;
        this.results = results;
        this.floors = new Floors(height);
    }

    public void generateFloorsWith(FloorFactory floorLinkGenerator) {
        int numberOfPositions = members.getNumberOfMembers();
        IntStream.range(0, floors.getMaxHeight())
                .mapToObj(y -> floorLinkGenerator.generate(numberOfPositions))
                .forEach(floors::addFloor);
    }

    public Members getMembers() {
        return members;
    }

    public Floors getFloors() {
        return floors;
    }

    public Results getResults() {
        return results;
    }

    public Result getResultOf(Member member) {
        Position position = new Position(members.getPositionOfMember(member), members.getNumberOfMembers());
        floors.followFrom(position);
        return results.getResultOfPosition(position.getCurrentPosition());
    }
}
