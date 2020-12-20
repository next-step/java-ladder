package nextstep.ladder.domain;

import nextstep.ladder.domain.floor.FloorFactory;
import nextstep.ladder.domain.floor.Floor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Members members;
    private final Height height;
    private List<Floor> floors = Collections.EMPTY_LIST;

    public Ladder(Members members, Height height) {
        this.members = members;
        this.height = height;
    }

    public void generateLadderWith(FloorFactory floorLinkGenerator) {
        int maxLinks = members.getNumberOfMembers() - 1;
        floors = IntStream.range(0, height.getHeight())
                .mapToObj(y -> floorLinkGenerator.generate(maxLinks))
                .collect(Collectors.toList());
    }

    public Members getMembers() {
        return members;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
