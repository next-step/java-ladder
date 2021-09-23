package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private int countOfPerson;
    private List<Boolean> points = new ArrayList<>();
    private static final RandomNumber randomNumber = new RandomNumber();
    private static int maxCountofLadder;
    private static final int FIVE = 5;
    private static final int THREE = 3;
    private static final int TWO = 2;
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private StringBuilder sb = new StringBuilder();

    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        maxCountofLadder = countOfPerson * TWO - ONE;
        //drawLine();
    }

    public void drawLine() {
        int totalLineSize = this.countOfPerson * TWO - ONE;
        for (int i = 0; i < totalLineSize; i++) {
            drawLineByNumber(i);
        }
    }

    public List<Boolean> points() {
        return this.points;
    }

    public int findRoute(int startPosition) {
        int movablePosition = startPosition;

        if (startPosition - ONE >= ZERO && isInstalledLadder(startPosition - ONE)) {
            movablePosition = moveLeft(movablePosition);
        }
        if (startPosition + ONE <= maxCountofLadder && isInstalledLadder(startPosition + ONE)) {
            movablePosition = moveRight(movablePosition);
        }
        return movablePosition;
    }

    private int moveLeft(int movablePosition) {
        while (isInstalledLadder(movablePosition - ONE)) {
            movablePosition--;
        }
        return movablePosition;
    }

    private int moveRight(int movablePosition) {
        while (isInstalledLadder(movablePosition + ONE)) {
            movablePosition++;
        }
        return movablePosition;
    }

    private boolean isInstalledLadder(int position) {
        if (position < 0 || position > maxCountofLadder - ONE) {
            return false;
        }
        return this.points.get(position);
    }

    private void drawLineByNumber(int position) {
        if (isEvenNumber(position)) {
            addHeightLine(position);
        }
        if (!isEvenNumber(position)) {
            addWidthLine(position);
        }
    }

    private boolean isEvenNumber(int position) {
        return position % TWO == ZERO;
    }

    private void addWidthLine(int position) {
        int installLadderNumber = randomNumber.randomNumber();
        boolean isInstallLadder = false;

        if (isInstallWidthLadder(installLadderNumber, position)) {
            isInstallLadder = true;
        }
        points.add(isInstallLadder);
    }

    private boolean checkAdjacentWidthLine(int position) {
        return !installedFirstLadderPosition(position) && checkBeforeExistenceWidthLadder(position);
    }

    private boolean checkBeforeExistenceWidthLadder(int position) {
        int beforeLadderPosition = position - TWO;
        return this.points.get(beforeLadderPosition);
    }

    private boolean installedFirstLadderPosition(int position) {
        return position < THREE;
    }

    private void addHeightLine(int position) {
        points.add(true);
    }

    private boolean isInstallWidthLadder(int number, int position) {
        return number > FIVE && !checkAdjacentWidthLine(position);
    }
}
