package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int DIVIDE_STANDARD = 2;

    private List<Boolean> points = new ArrayList<>();

    public Line(int index, int countOfParticipants) {
        makePoints(index, countOfParticipants);
    }

    private void makePoints(int lineIndex, int countOfParticipants) {
        int pointSize = countOfParticipants-1;

        String lineGenStandard = checkEvenOdd(lineIndex);

        if (lineGenStandard.equals("even")) {
            generateEvenPoint(pointSize);
            return;
        }

        if (lineGenStandard.equals("odd")) {
            generateOddPoint(pointSize);
        }
    }

    private void generateEvenPoint(int pointSize) {
        for(int pointIndex = 0; pointIndex < pointSize; pointIndex++) {
            addEvenPoint(pointIndex);
        }
    }

    private void addEvenPoint(int pointIndex) {
        if (pointIndex % DIVIDE_STANDARD == 0) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    private void generateOddPoint(int pointSize) {
        for(int pointIndex = 0; pointIndex < pointSize; pointIndex++) {
            addOddPoint(pointIndex);
        }
    }

    private void addOddPoint(int pointIndex) {
        if (pointIndex % DIVIDE_STANDARD != 0) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    private String checkEvenOdd(int lineIndex) {
        return lineIndex % DIVIDE_STANDARD == 0 ? "even" : "odd";
    }


    public int getPointsLength() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return this.points;
    }
}
