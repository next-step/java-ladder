package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Crosses {
    private final List<Cross> crosses;

    private Crosses(List<Cross> crosses) {
        this.crosses = crosses;
    }

    public static Crosses from(List<Point> points) {
        List<Cross> crosses = IntStream.range(0, points.size())
                .mapToObj(idx -> new Cross(idx, points.get(idx)))
                .collect(Collectors.toList());
        return new Crosses(crosses);
    }

    public int move(int idx) {
        return crosses.get(idx).move();
    }

    public List<Boolean> getPoints() {
        return IntStream.range(0, crosses.size() - 1)
                .mapToObj(i -> crosses.get(i).getCurrent())
                .collect(Collectors.toList());
    }

}
