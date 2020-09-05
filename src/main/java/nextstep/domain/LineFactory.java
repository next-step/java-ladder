package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineFactory {

    private static final TransverseBarStrategy DEFAULT_TRANSVERSE_BAR_STRATEGY = new RandomTransverseBarStrategy();

    private LineFactory() {

    }

    public static Line createLine(int countOfPerson, TransverseBarStrategy transverseBarStrategy) {
        return new Line(countOfPerson, transverseBarStrategy);
    }

    public static List<Line> createLines(Participants participants, LadderHeight ladderHeight) {
        return createLines(participants.getPersonSize(), ladderHeight.getLadderHeight());
    }

    public static List<Line> createLines(int countOfPerson, int ladderHeight) {
        return createLines(countOfPerson, ladderHeight, DEFAULT_TRANSVERSE_BAR_STRATEGY);
    }

    public static List<Line> createLines(int countOfPerson, int ladderHeight, TransverseBarStrategy transverseBarStrategy) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> createLine(countOfPerson, transverseBarStrategy))
                .collect(Collectors.toList());
    }

}
