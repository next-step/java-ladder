package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> line = new ArrayList<>();

    public Line(int countOfPerson) {
        List line = generate(countOfPerson);
        this.line = line;
    }

    public Line(List<Boolean> list) {
        this.line = list;
    }

    public Line(GameInformation gameInformation) {
        this(gameInformation.getUsers().size());
    }

    private List generate(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            checkSuccessTrue(line, i);
        }
        return line;
    }

    private void checkSuccessTrue(List<Boolean> line, int index) {
        if (index > 0 && line.get(index - 1)) {
            line.add(false);
            return;
        }
        line.add(new Random().nextBoolean());
        return;
    }

    public int size() {
        return line.size();
    }

    public boolean isTrue(int index) {
        return line.get(index);
    }

    public int numberOfTrue() {
        return (int) line.stream()
                .filter(n -> n.equals(true))
                .count();
    }

    public void isMove(Point point) {
        if (isMostLeftPoint(point)) {
            checkRightMove(point);
            return;
        }
        if (isMostRightPoint(point)) {
            checkLeftMove(point);
            return;
        }
        checkLeftAndRightMove(point);
    }

    private boolean isMostLeftPoint(Point point) {
        return point.isEqualToPoint(0);
    }

    private boolean isMostRightPoint(Point point) {
        return point.isEqualToPoint(line.size());
    }

    private void checkLeftAndRightMove(Point point) {
        int originalPoint = point.getPoint();
        checkLeftMove(point);
        if (point.isEqualToPoint(originalPoint)) {
            checkRightMove(point);
        }
    }

    private void checkLeftMove(Point point) {
        if (isLeftTrue(point)) {
            point.moveLeft();
        }
        return;
    }

    private Boolean isLeftTrue(Point point) {
        return line.get(point.getPoint() - 1);
    }

    private void checkRightMove(Point point) {
        if (isRightTrue(point)) {
            point.moveRight();
        }
        return;
    }

    private Boolean isRightTrue(Point point) {
        return line.get(point.getPoint());
    }

    public boolean onlyFalse() {
        return numberOfTrue() == 0;
    }
}
