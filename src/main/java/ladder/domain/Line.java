package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private int pointCount;
    private int countOfPerson;
    private List<Boolean> points = new ArrayList<>();
    private List<Integer> lineInfoList = new ArrayList<>();
    private final RandomNumber randomNumber = new RandomNumber();

    private StringBuilder sb = new StringBuilder();

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

    public List<Integer> lineInfoList() {
        return this.lineInfoList;
    }

    private boolean checkAdjustLine(int countOfPerson, int position) {
        return countOfPerson > 2 && position > 1 && points.get(position - 2);
    }

    private int calculatePointByPeople() {
        return countOfPerson * 2 - 1;
    }

    private boolean isHeightLadder(int index) {
        return index % 2 == 0;
    }

    private boolean isWidthLadder(int index, boolean installableWidthLadder) {
        return index % 2 != 0 && installableWidthLadder;
    }

    private boolean isEmptySpace(int index, boolean installableWidthLadder) {
        return index % 2 != 0 && !installableWidthLadder;
    }

    public void addLine() {
        for (int i = 0; i < pointCount; i++) {
            checkPointLine(i, installableWidthLadder(i));
        }
    }

    private boolean installableWidthLadder(int index) {
        int resultRandomNumber = randomNumber.randomNumber();
        boolean installableWidthLadder = randomNumber.installableLadder(resultRandomNumber);
        return installableWidthLadder && !checkAdjustLine(countOfPerson, index);
    }

    public void checkPointLine(int index, boolean installableWidthLadder) {

        if (isHeightLadder(index)) {
            lineInfoList.add(1);
        }

        if (isWidthLadder(index, installableWidthLadder)) {
            lineInfoList.add(2);
        }

        if (isEmptySpace(index, installableWidthLadder)) {
            lineInfoList.add(0);
        }

    }


    public List<Boolean> points() {
        return this.points;
    }


}
