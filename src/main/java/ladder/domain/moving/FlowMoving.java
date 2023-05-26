package ladder.domain.moving;

import java.util.Arrays;
import ladder.domain.line.Line;

public class FlowMoving implements MovingStrategy {

    private static FlowMoving instance = null;

    private FlowMoving() {}

    public static FlowMoving instance() {
        if (instance == null) {
            instance = new FlowMoving();
        }
        return instance;
    }

    @Override
    public Moving nextMoving(Line line, int pos) {
        if (line == null || line.length() == 0) {
            return Moving.STOP;
        }
        return Arrays.stream(Moving.values())
            .filter(v -> v.type().left().equals(properLeft(line, pos)) && v.type().right().equals(properRight(line, pos)))
            .findFirst()
            .orElse(Moving.STOP);
    }

    private Boolean properRight(Line line, int pos) {
        return (0 <= pos && pos < line.length()) ? line.points().get(pos) : Boolean.FALSE;
    }

    private Boolean properLeft(Line line, int pos) {
        return (0 < pos && pos <= line.length()) ? line.points().get(pos - 1) : Boolean.FALSE;
    }

}
