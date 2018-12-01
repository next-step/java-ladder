package domain;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Line implements LineStrategy {
    private ArrayList<Boolean> points = new ArrayList<>();

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

    private void LoopLine(int countOfPerson, Random rand) {
        IntStream.range(1, countOfPerson-1).forEach(i -> {
            points.add(false);
            hasLineBefore(rand, i);
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