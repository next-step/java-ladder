package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineFactory {

    private LineFactory() {

    }

    public static Line createLine(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public static List<Line> createLines(Participants participants, LadderHeight ladderHeight) {
        return IntStream.range(0, ladderHeight.getLadderHeight())
                .mapToObj(i -> createLine(participants.getPersonSize()))
                .collect(Collectors.toList());
    }

}
