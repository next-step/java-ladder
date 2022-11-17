package ladder.domain;

import static ladder.domain.Direction.RIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.strategy.LinkStrategy;

public class Line {

    private final PositiveInt size;
    private final List<Direction> directions = new ArrayList<>();

    public Line(final PositiveInt size) {
        this.size = size;
    }

    public void link(final LinkStrategy strategy) {
        directions.addAll(strategy.link(size.getValue()));
    }

    public Point move(final Point point) {
        int currentIndex = point.getIndexValue();
        return point.move(directions.get(currentIndex));
    }

    public List<Boolean> getAllIsLinked() {
        return directions.stream().
            map(this::isLinked).
            collect(Collectors.toList());
    }

    private boolean isLinked(final Direction direction) {
        return direction == RIGHT;
    }
}
