package domain;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Line implements LineStrategy {
    private ArrayList<Boolean> points = new ArrayList<>();
    ArrayList<Integer> resultBox = new ArrayList<>();

    private Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        Random rand = new Random();
        points.add(false);
        canAddLine(rand, 0);
        LoopLine(countOfPerson, rand);
        points.add(false);
    }

    public static Line from(int countOfPerson) {
        return new Line(countOfPerson);
    }

    boolean canMove(int j) {
        if(points.get(j)) {
            return true;
        }
        return false;
    }

    private void LoopLine(int countOfPerson, Random rand) {
        IntStream.range(1, countOfPerson-1).forEach(i -> {
            points.add(false);
            hasLineBefore (rand, i);
        });
        IntStream.range(0, countOfPerson).forEach(i -> {
            resultBox.add(i);
        });
    }

    private void hasLineBefore(Random rand, int i) {
        if (points.get(i - 1) == false) {
            canAddLine(rand, i);
        }
    }

    private void canAddLine(Random rand, int i) {
        if (rand.nextInt(10) > 5) {
            points.set(i, true);
        }
    }

    public String drawOrNot() {
        String str = "";
        for (Boolean bool : points) {
            str += "|";
            if (bool == true) {
                str += "-----";
            }
            if (bool == false) {
                str += "     ";
            }
        }
        return str;
    }

    public void followLine(int dot, int j) {
        if(canMove(j)) {
            resultBox.set(dot, resultBox.get(dot) + 1);
        }
    }

    public ArrayList<Integer> processLining(int dot) {
        for(int j : resultBox) {
            followLine(dot, j);
            if(j != 0) {
                followBeforeLine(dot, j-1);
            }
            dot++;
        }
        return resultBox;
    }

    public void followBeforeLine(int dot, int j) {
        if(canMove(j)) {
            resultBox.set(dot, resultBox.get(dot) - 1);
        }
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }

    @Override
    public boolean isExist() {
        return false;
    }

    @Override
    public String toString() {
        return "domain.Line{" +
                "points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}