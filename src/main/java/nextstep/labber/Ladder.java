package nextstep.labber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    public static List<Line> createLadder(int participantsCount, int ladderHeight) {
        return Stream.generate(() -> new Line(participantsCount))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }
}
