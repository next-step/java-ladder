package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    public List<Boolean> points = new ArrayList<>();

    public Line (int numberOfPerson) {
        int countToPoint = numberOfPerson - 1;

        points.add(new Random().nextBoolean());

        while (points.size() < (countToPoint) && !(numberOfTrue(points) < 0))  {
            generatePoint(countToPoint, points);
        }
    }

    private boolean nextPoint(boolean prevPoint) {
        return (prevPoint == true) ? false : (new Random().nextBoolean());
    }

    private void generatePoint(int countToPoint, List<Boolean> points) {
        for (int i = 0 ; i < countToPoint-1 ; i++) {
            points.add(nextPoint(points.get(i)));
        }
    }

    private int numberOfTrue(List<Boolean> list) {
        int sum = 0;
        for(boolean b : list) {
            sum += b ? 1 : 0;
        }
        return sum;
    }

    public void printLine() {
        String line = "";
        for (int i = 0 ; i < points.size() ; i++) {
            line += "|";
            if (points.get(i) == true) {
                line += "-----";
            } else {
                line += "     ";
            }
        }
        line += "|";
        System.out.println(line);
    }

}
