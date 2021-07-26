package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private int countOfPerson;
    private List<Boolean> points = new ArrayList<>();
    private final RandomNumber randomNumber = new RandomNumber();

    private StringBuilder sb = new StringBuilder();

    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
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
        return !StartPosition(position) && checkBeforeExistenceWidthLadder(position);
    }

    private boolean checkBeforeExistenceWidthLadder(int position) {
        return this.points.get(position - 2);
    }

    private boolean StartPosition(int position) {
        return position < 1;
    }

    private void addHeightLine(int position) {
        points.add(true);
    }


    private boolean isInstallWidthLadder(int number, int position) {
        return number > 5 && !checkAdjacentWidthLine(position);
    }


}
