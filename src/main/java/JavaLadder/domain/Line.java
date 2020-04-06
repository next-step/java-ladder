package JavaLadder.domain;

import java.util.*;

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
        List<Boolean> points = new ArrayList();
        for (int i = 0; i < countOfPerson - 1; i++) {
            checkSuccessTrue(line, i);
        }
        return line;
    }

    private void checkSuccessTrue(List<Boolean> line, int i) {
        if (i > 0 && line.get(i - 1)) {
            line.add(false);
            return;
        }
        line.add(new Random().nextBoolean());
        return;
    }

    @Override
    public String toString() {
        return line.toString();
    }

    public Boolean isLine(int i) {
        return this.line.get(i);
    }

    public int size() {
        return this.line.size();
    }

    public int countLine() {
        return (int) Arrays.asList(line).stream().filter(n -> true).count();
    }

    public void moveByLine(Point point) {
        if (point.getPoint() == 0) {
            checkRightMove(point);
            return;
        }
        if (point.getPoint() == line.size()) {
            checkLeftMove(point);
            return;
        }
        checkLeftAndRightMove(point);
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
            point.leftMove();
        }
        return;
    }

    private void checkRightMove(Point point) {
        if (line.get(point.getPoint())) {
            point.rightMove();
        }
        return;
    }
}
