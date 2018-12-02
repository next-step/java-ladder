    package domain;

import java.util.*;
import java.util.stream.IntStream;

public class Line implements LineStrategy {
    private List<Boolean> points = new ArrayList<>();

    private List<Integer> resultBox = new ArrayList<>();

    private Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        Random rand = new Random();
        points.add(false);
        canAddLine(rand, 0);
        loopLine(countOfPerson, rand);
        points.add(false);
    }

    public static Line from(int countOfPerson) {
        return new Line(countOfPerson);
    }

    private void loopLine(int countOfPerson, Random rand) {
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

    String drawOrNot() {
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

    public boolean canMove(int j) {
        if(points.get(j)) {
            return true;
        }
        return false;
    }

    public void moveRight(int dot, int j) {
        if(canMove(j)) {
            resultBox.set(dot, resultBox.get(dot) + 1);
            //return 1;
        }
    }

    public void moveLeft(int dot, int j) {
        if(canMove(j)) {
            resultBox.set(dot, resultBox.get(dot) - 1);
            //return -1;
        }
    }

    public List<Integer> processLining(int dot) {
        for(int j : resultBox) {
            moveRight(dot, j);
            if(j != 0) {
                moveLeft(dot, j-1);
            }
            dot++;
        }
        return resultBox;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public List<Integer> getResultBox() {
        return Collections.unmodifiableList(resultBox);
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