package model;

import java.util.ArrayList;
import java.util.Optional;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();
    private int countOfPerson;
    private Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;

        for (int i = 0; i < countOfPerson; i++) {
            addPoint(false);
        }
    }
    public static Line of(int countOfPerson, int[] indexs) {
        Line line = new Line(countOfPerson);
        line.setLines(indexs);

        return line;
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public static Line of(String countOfPerson) {
        return of(Integer.valueOf(countOfPerson));
    }

    public boolean hasPoint(int point) {
        if(point >= points.size()) {
            return false;
        }

        return points.get(point);
    }


    public void addPoint(boolean b) {
        validPoints(points.size());

        points.add(b);
    }

    public void setLines(int[] indexs) {
        for (int idx : indexs) {
            setLine(idx);
        }
    }

    public void setLine(int index) {
        validPoints(index);
        if(index == points.size()-1) {
           throw new IllegalArgumentException("선 생성 불가");
        }

        if(index == 0) {
            if(hasPoint(index+1)) {
                throw new IllegalArgumentException("선 생성 불가");
            }
        } else {
            if(hasPoint(index-1) || hasPoint(index+1)) {
                throw new IllegalArgumentException("선 생성 불가");
            }
        }


        points.set(index, true);
    }

    private void validPoints(int index) {
        if (index >= countOfPerson) {
            throw new IllegalStateException("최대 포인트를 초과할 수 없습니다.");
        }
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}
