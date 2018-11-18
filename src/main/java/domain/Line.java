package domain;

import utils.BooleanGenerator;
import utils.StringUtils;

import java.util.List;

public class Line {
    private final String VERTICAL_BAR = "|";
    private final int RIGHT = 1;
    private final int LEFT = -1;
    private final int LINE_WIDTH = 5;
    private List<Boolean> points;

    private Line(int countOfPerson) {
        if (countOfPerson < 0) {
            throw new RuntimeException("음수가 올 수 없습니다.");
        }
        BooleanGenerator booleanGenerator = new BooleanGenerator();
        points = booleanGenerator.generateLine(countOfPerson);
    }

    private Line(List<Boolean> points) {
        for (int i = 1; i < getSize(); i++) {
            if (isMove(i - 1) && isMove(i)) {
                throw new RuntimeException("성립할 수 없는 사다리 구조입니다.");
            }
        }

        this.points = points;
    }

    public static Line ofCount(int size) {
        return new Line(size);
    }

    public static Line ofGroup(List<Boolean> points) {
        return new Line(points);
    }

    @Override
    public String toString() {
        return points.stream().map(x -> drawLine(x)).reduce("", (x, y) -> x + VERTICAL_BAR + y).concat(VERTICAL_BAR);
    }

    private String drawLine(Boolean bool) {
        if (bool) {
            return StringUtils.getReplace(StringUtils.MID_BAR, LINE_WIDTH);
        }
        return StringUtils.getReplace(StringUtils.SPACE, LINE_WIDTH);
    }

    public int nextPosition(int currentPosition) {
        if(currentPosition >= 0 && currentPosition < getSize()){
            if (isMove(currentPosition)) return currentPosition + RIGHT;
        }
        if(currentPosition > 0 && currentPosition <= getSize()){
            if (isMove(currentPosition + LEFT)) return currentPosition + LEFT;
        }
        return currentPosition;
    }

    private int getSize() {
        return this.points.size();
    }

    private boolean isMove(int position) {
        return points.get(position);
    }
}
