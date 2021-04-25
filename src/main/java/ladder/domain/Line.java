package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private int pointCount = 0;
    private int widthLadderCount = 0;
    private int countOfPerson = 0;
    private static final String EMPTY_WIDTH_LADDER = "     ";
    private StringBuilder sb = new StringBuilder();
    private final RandomNumber randomNumber = new RandomNumber();


    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        pointCount = calculatePointByPeople();
        addLine();
    }

    public void addWidthLine(int position) {
        if (!checkAdjustLine(countOfPerson, position)) {
            points.set(position, true);
        }
    }

    private boolean checkAdjustLine(int countOfPerson, int position) {
        return countOfPerson > 2 && position > 1 && points.get(position - 2);
    }

    private int calculatePointByPeople() {
        widthLadderCount = countOfPerson - 1;
        return widthLadderCount + countOfPerson;
    }

    private void drawOneLineLadder(int index) {
        if (isHeightLadder(index)) {
            sb.append("|");
        }

        if (!isHeightLadder(index) && isDrawOneWidthLadder(index)) {
            sb.append("-----");
        }

        if (!isHeightLadder(index) && !isDrawOneWidthLadder(index)) {
            sb.append(EMPTY_WIDTH_LADDER);
        }
    }

    private boolean isDrawOneWidthLadder(int index) {
        return points.get(index);
    }

    private boolean isHeightLadder(int index) {
        return index % 2 == 0 ? true : false;
    }


    public void addLine() {
        for (int i = 0; i < pointCount; i++) {
            checkPointLine(i, makableWidthLadder(i));
        }
    }

    private boolean makableWidthLadder(int index) {
        int resultRandomNumber = randomNumber.randomNumber();
        boolean makableWidthLadder = randomNumber.makableLadder(resultRandomNumber);
        return makableWidthLadder && !checkAdjustLine(countOfPerson, index);
    }

    public void checkPointLine(int index, boolean makableWidthLadder) {

        if (index % 2 == 0) {
            points.add(index, true);
        }

        if (index % 2 != 0 && makableWidthLadder) {
            points.add(index, true);
        }

        if (index % 2 != 0 && !makableWidthLadder) {
            points.add(index, false);
        }

    }


    public List<Boolean> points() {
        return this.points;
    }

    @Override
    public String toString() {
        sb.append("\t");
        for (int i = 0; i < pointCount; i++) {
            drawOneLineLadder(i);
        }
        return sb.toString();

    }
}
