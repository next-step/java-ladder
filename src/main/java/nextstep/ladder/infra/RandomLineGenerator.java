package nextstep.ladder.infra;

import nextstep.ladder.domain.LineGenerator;
import nextstep.ladder.domain.LineLength;
import nextstep.ladder.domain.LinePoint;
import nextstep.ladder.domain.MoveDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLineGenerator implements LineGenerator {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public List<LinePoint> generate(LineLength length) {
        List<LinePoint> line = new ArrayList<>();
        LinePoint current = null;
        for (int i = 0; i < length.getLength(); i++) {
            current = generateLinePoint(length, i, current);
            line.add(current);
        }

        return line;
    }

    private LinePoint generateLinePoint(LineLength length, int current, LinePoint previous) {
        List<MoveDirection> possibleMoveDirection = getPossibleMoveDirectionForRight();
        if (previous != null && previous.canMoveRight()) {
            return LinePoint.of(MoveDirection.LEFT);
        }
        if (current == length.getLength() - 1) {
            return LinePoint.of(MoveDirection.NON);
        }
        if (current == 0) {
            possibleMoveDirection = getPossibleMoveDirectionForRight();
        }

        MoveDirection moveDirection = possibleMoveDirection.get(random.nextInt(0, possibleMoveDirection.size()));
        return LinePoint.of(moveDirection);
    }

    private List<MoveDirection> getPossibleMoveDirectionForRight() {
        return List.of(MoveDirection.RIGHT, MoveDirection.NON);
    }

}
