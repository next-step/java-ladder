package domain;

import util.PointProvider;
import util.StringUtil;

import java.util.List;

public class Line {
    private final String VERTICAL_BAR = "|";
    private final int LADDER_WIDTH = 5;
    private final int RIGHT = 1;
    private final int LEFT = -1;

    private static PointProvider provider = new PointProvider();
    private List<Boolean> points;

    private Line(List<Boolean> points) {
        for (int i = 1; i < getSize(); i++) {
            if (isMove(i - 1) && isMove(i)) {
                throw new RuntimeException("성립할 수 없는 사다리 구조입니다.");
            }
        }
        this.points = points;
    }

    private Line(int countOfPerson) {
        if (countOfPerson < 0) {
            throw new RuntimeException("음수가 올 수 없습니다.");
        }this.points = provider.generate(countOfPerson);
    }

    public static Line of(List<Boolean> points) {
        return new Line(points);
    }

    public static Line ofCount(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public int getNextPosition(int currentPosition) {
        if (currentPosition >= 0 && currentPosition < getSize()) {
            if (isMove(currentPosition)) return currentPosition + RIGHT;
        }
        if (currentPosition > 0 && currentPosition <= getSize()) {
            if (isMove(currentPosition + LEFT)) return currentPosition + LEFT;
        }
        return currentPosition;
    }

    private int getSize() {
        return points.size();
    }

    private boolean isMove(int position) {
        return points.get(position);
    }


    @Override
    public String toString() {
        return points.stream().map(x -> drawLine(x)).reduce("", (x, y) -> x + VERTICAL_BAR + y).concat(VERTICAL_BAR);
    }

    private String drawLine(boolean isMiddleBar) {
        if (isMiddleBar) {
            return StringUtil.getReplace(StringUtil.MID_BAR, LADDER_WIDTH);
        }
        return StringUtil.getReplace(StringUtil.SPACE, LADDER_WIDTH);
    }
}
