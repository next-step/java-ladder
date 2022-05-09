package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine
{
    private final List<Boolean> points;
    private final int range;
    private static final int LANGE_START = 0;
    private static final int LINE_LENGTH_FOR_USER = 5;

    public LadderLine(int userCount, int range)
    {
        this.points = IntStream.range(LANGE_START, userCount * LINE_LENGTH_FOR_USER)
            .mapToObj(i -> false)
            .collect(Collectors.toList());
        this.range = range;

    }
}
