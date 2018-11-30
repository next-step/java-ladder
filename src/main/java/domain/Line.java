package domain;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Line implements LineStrategy {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        Random rand = new Random();
        points.add(false);
        if(rand.nextInt(10) > 5) {
            points.set(0, true);
        }
        for (int i = 1; i < countOfPerson - 1; i++) {
            points.add(false);
            if(rand.nextInt(10) > 5) {
                if (points.get(i - 1) == false) {
                    points.set(i, true);
                }
            }
        }
        points.add(false);
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