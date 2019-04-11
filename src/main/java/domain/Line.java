package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int numberOfPerson) {
        int countToPoint = numberOfPerson - 1;
        points.add(new Random().nextBoolean());
        while (points.size() < countToPoint && (numberOfTruePoints() >= 0))  {
            generatePoint(countToPoint);
        }
    }

    public int move(int currentPosition) {
        int nextLeftPoisition = currentPosition - 1;

        if (nextLeftPoisition > -1 && points.get(nextLeftPoisition)) {
            return nextLeftPoisition;
        }
        if (currentPosition < points.size() && points.get(currentPosition)) {
            return currentPosition + 1;
        }
        return currentPosition;
    }

    private boolean nextPoint(boolean prevPoint) {
        return !prevPoint && new Random().nextBoolean();
    }

    private void generatePoint(int countToPoint) {
        for (int i = 0; i < countToPoint - 1; i ++) {
            points.add(nextPoint(points.get(i)));
        }
    }

    public int numberOfTruePoints() {
        int sum = 0;
        for (boolean point : points) {
            sum += point ? 1 : 0;
        }
        return sum;
    }

    public void printLine() {
        String line = "";
        for (boolean point : points) {
            line += "|";
            line += point ? "-----" : "     ";
        }
        line += "|";
        System.out.println(line);
    }



}
