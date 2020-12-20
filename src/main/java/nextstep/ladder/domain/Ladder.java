package nextstep.ladder.domain;

import nextstep.ladder.domain.floor.FloorFactory;
import nextstep.ladder.domain.floor.Floor;
import nextstep.ladder.domain.floor.Floors;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Members members;
    private final Floors floors;

    public Ladder(Members members, Height height) {
        this.members = members;
        this.floors = new Floors(height);
    }

    public void generateFloorsWith(FloorFactory floorLinkGenerator) {
        int maxLinks = members.getNumberOfMembers() - 1;
        IntStream.range(0, floors.getMaxHeight())
                .mapToObj(y -> floorLinkGenerator.generate(maxLinks))
                .forEach(floors::addFloor);
    }

    public Members getMembers() {
        return members;
    }

    public Floors getFloors() {
        return floors;
    }
}
