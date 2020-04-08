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
        return this.line.get(index);
    }

    public int numberOfTrue() {
        return (int) line.stream().filter(n -> n.equals(true)).count();
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
        return point.getPoint() == 0;
    }

    private boolean isMostRightPoint(Point point) {
        return point.getPoint() == line.size();
    }

    private void checkLeftAndRightMove(Point point) {
        int originalPoint = point.getPoint();
        checkLeftMove(point);
        if(originalPoint == point.getPoint()){
            checkRightMove(point);
        }
    }

    private void checkLeftMove(Point point) {
        if (line.get(point.getPoint() - 1)) {
            point.moveLeft();
        }
        return;
    }

    private void checkRightMove(Point point) {
        if (line.get(point.getPoint())) {
            point.moveRight();
        }
        return;
    }
}
