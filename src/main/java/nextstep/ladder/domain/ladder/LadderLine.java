package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.direction.Direction;
import nextstep.ladder.domain.direction.DirectionDeterminer;
import nextstep.ladder.domain.direction.Point;
import nextstep.ladder.domain.direction.RandomLineGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {

    private final List<Direction> directions;

    public LadderLine(List<Direction> directions) {
        this.directions = directions;
    }

    public static LadderLine of(int groupCount) {
        DirectionDeterminer generator = new DirectionDeterminer(RandomLineGenerator.getInstance());
        List<Direction> directions = new ArrayList<>();

        for (int i = 0; i < groupCount - 1; i++) {
            directions.add(generator.next());
        }
        directions.add(generator.last());
        return new LadderLine(directions);
    }

    public Point play(Point point) {
        System.out.println(point + ", " + directions.get(point.getX()));
        return point.movePoint(directions.get(point.getX()));
    }

    public Collection<Boolean> lines() {
        return directions.subList(0, directions.size() - 1).stream()
                .map(this::isLine)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isLine(Direction direction) {
        return direction == Direction.RIGHT_DOWN;
    }
}
