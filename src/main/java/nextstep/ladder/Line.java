package nextstep.ladder;

import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(int countOfVerticalLine, LineStrategy lineStrategy) {
        this.points = lineStrategy.generate(countOfVerticalLine);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int getPointSize() {
        return points.size();
    }

    public int moveLine(int verticalLine) {

        if (isFirstVertical(verticalLine)) {
            if (checkRightLine(verticalLine)) {
                return goToRight(verticalLine);
            }
            return verticalLine;
        }

        if (isLastVertical(verticalLine)) {
            if (checkLeftLine(verticalLine)) {
                return goToLeft(verticalLine);
            }
            return verticalLine;
        }

        if (checkRightLine(verticalLine)) {
            return goToRight(verticalLine);
        }

        if (checkLeftLine(verticalLine)) {
            return goToLeft(verticalLine);
        }

        return verticalLine;
    }

    private int goToRight(int vertical){
        return vertical + 1;
    }

    private int goToLeft(int vertical){
        return vertical - 1;
    }

    private boolean checkLeftLine(int vertical) {
        return points.get(vertical - 1);
    }

    private boolean checkRightLine(int vertical) {
        return points.get(vertical);
    }

    private boolean isFirstVertical(int vertical) {
        return vertical == 0;
    }

    private boolean isLastVertical(int vertical) {
        return vertical == points.size();
    }
}
