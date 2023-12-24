package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        int countOfPoint = countOfPerson - 1;
        for (int i = 0; i < countOfPoint; i++) {
            this.points.add(createLine(i));
        }
        checkLine(this.points);
    }

    public Line(List<Boolean> points) {
        checkLine(points);
        this.points = points;
    }

    private Boolean createLine(int index) {
        Random random = new Random();
        if (index == 0) {
            return random.nextBoolean();
        }
        if (points.get(index - 1)) {
            return false;
        }
        return random.nextBoolean();
    }

    private void checkLine(List<Boolean> points) {
        for (int i = 1; i < points.size(); i++) {
            compareTo(points.get(i-1), points.get(i));
        }
    }

    public void compareTo(Boolean o1, Boolean o2) {
        if (o1 && o2) {
            throw new IllegalArgumentException("라인을 겹치게 할 수 없습니다.");
        }
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int move(int index) {
        if (isPossibleMoveLeft(index)) {
            return -1;
        }
        if (isPossibleMoveRight(index)) {
            return 1;
        }
        return 0;
    }

    private boolean isPossibleMoveLeft(int index) {
        if ((index == points.size() + 1 && points.get(index))
        || (0 < index && index <= points.size() && points.get(index - 1))) {
            return true;
        }

        return false;
    }

    private boolean isPossibleMoveRight(int index) {
        if (0 <= index && index < points.size() && points.get(index)) {
            return true;
        }
        return false;
    }
}
