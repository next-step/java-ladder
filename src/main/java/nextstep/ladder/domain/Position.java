package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.exception.ExceptionMessage.*;

public class Position {

    private static final List<Position> POSITIONS = new ArrayList<>();
    private static final int[] DIRECTIONS = {0 , -1};
    public static final int DEPTH_ADJUSTMENT = 1;

    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void init(Width width, Height height){
        validateInit();

        List<Position> init = Stream.iterate(0, i -> i + 1)
            .limit(height.value() + 1)
            .flatMap(i -> create(width, i))
            .collect(Collectors.toUnmodifiableList());

        POSITIONS.addAll(init);
    }

    private static Stream<Position> create(Width width, int height) {
        return Stream.iterate(0, i -> i+1)
            .limit(width.value())
            .map(i -> new Position(i, height));
    }

    private static void validateInit() {
        if (!POSITIONS.isEmpty()) {
            throw new IllegalArgumentException(COORDINATE_IS_INIT.message());
        }
    }

    public static Position of(int x, int y) {
        validateNotInit();

        return POSITIONS.stream()
            .filter(coordinate -> coordinate.x == x && coordinate.y == y)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(COORDINATE_OUR_OF_RANGE.message()));
    }

    private static void validateNotInit() {
        if (POSITIONS.isEmpty()) {
            throw new IllegalArgumentException(COORDINATE_IS_NOT_INIT.message());
        }
    }

    protected static void clear() {
        POSITIONS.clear();
    }

    public Position findNextCoordinate(Bridges bridge) {
        return Arrays.stream(DIRECTIONS)
            .filter(direction -> bridge.isMovableSide(x + direction))
            .mapToObj(direction -> movableSide(direction, x + direction))
            .findAny()
            .orElse(Position.of(x, nextHeight(y)));
    }

    private Position movableSide(int direction, int next) {
        if (direction == DIRECTIONS[0]) {
            return Position.of(next + DEPTH_ADJUSTMENT, nextHeight(y));
        }

        return Position.of(next, nextHeight(y));
    }

    private int nextHeight(int y) {
        return y + DEPTH_ADJUSTMENT;
    }
}
