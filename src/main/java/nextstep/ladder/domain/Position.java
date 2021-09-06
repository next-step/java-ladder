package nextstep.ladder.domain;

import java.util.List;

public class Position {

    private int startPosition;

    private int lastPosition;

    public Position(int startPosition, int lastPosition) {
        this.startPosition = startPosition;
        this.lastPosition = lastPosition;
    }

    public Position(int startPosition) {
        this.startPosition = startPosition;
    }

    public Result findUserResult(List<Result> results) {
        return results.get(lastPosition);
    }

    public int findLastPosition(Ladder ladder) {
        lastPosition = ++startPosition;

        addFakePoint(ladder);

        ladder.getLadder().stream().forEach(line -> moveByPoint(line.getPoints()));

        removeFakePoint(ladder);

        lastPosition--;
        return lastPosition;
    }

    private void moveByPoint(List<Boolean> points) {
        if (points.get(lastPosition)) {
            ++lastPosition;
            return;
        }
        if (points.get(lastPosition - 1)) {
            --lastPosition;
        }
    }

    private void addFakePoint(Ladder ladder) {
        ladder.getLadder().stream()
                .forEach(line -> {
                    line.getPoints().add(false);
                    line.getPoints().add(0, false);
                });
    }

    private void removeFakePoint(Ladder ladder) {
        ladder.getLadder().stream()
                .forEach(line -> {
                    line.getPoints().remove(0);
                    line.getPoints().remove(line.getPoints().size() - 1);
                });
    }
}
