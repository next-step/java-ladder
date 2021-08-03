package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private int countOfPerson;
    private List<Boolean> points = new ArrayList<>();
    private static final RandomNumber randomNumber = new RandomNumber();
    private static int maxCountofLadder;
    private static final int FIVE = 5;

    private StringBuilder sb = new StringBuilder();

    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        maxCountofLadder = countOfPerson * 2 - 1;
        drawLine();
    }

    public void drawLine() {
        int totalLineSize = this.countOfPerson * 2 - 1;
        for (int i = 0; i < totalLineSize; i++) {
            drawLineByNumber(i);
        }
    }

    public List<Boolean> points() {
        return this.points;
    }

    public int findRoute(int startPosition) {
        int movablePosition = startPosition;

        if (isInstalledLadder(startPosition - 1)) {
            movablePosition = moveLeft(movablePosition);
        }

        if (isInstalledLadder(startPosition + 1)) {
            movablePosition = moveRight(movablePosition);
        }

        return movablePosition;
    }

    private int moveLeft(int movablePosition) {
        while (movablePosition > 0 && isInstalledLadder(movablePosition--)) {

        }

        return movablePosition;
    }

    private int moveRight(int movablePosition) {
        while (movablePosition > 0 && isInstalledLadder(movablePosition++)) {

        }

        return movablePosition;
    }


    private boolean isInstalledLadder(int position) {
        if (position < 0 || position >= maxCountofLadder) {
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
        return position % 2 == 0;
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
        int beforeLadderPosition = position - 2;
        return this.points.get(beforeLadderPosition);
    }

    private boolean installedFirstLadderPosition(int position) {
        return position < 3;
    }

    private void addHeightLine(int position) {
        points.add(true);
    }

    private boolean isInstallWidthLadder(int number, int position) {
        return number > FIVE && !checkAdjacentWidthLine(position);
    }


}
