package ladder.dto;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line() {
        //
    }

    public Line(int countOfPerson) {
        if (countOfPerson <= 0) {
            throw new IllegalArgumentException("양수여야 합니다.");
        }

        this.points.add(getNewPoint());
        for (int idx = 1; idx < countOfPerson -1; idx++) {
            addNewPoint(idx);
        }
    }

    private void addNewPoint(int idx) {
        if (validateLastIdx(idx - 1)) {
            this.points.add(getNewPoint());
        }
    }

    private boolean validateLastIdx(int lastIdx) {
        if (this.points.get(lastIdx)) {
            this.points.add(false);
            return false;
        }
        return true;
    }

    private boolean getNewPoint() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) {
            return true;
        }
        return false;
    }

    public List<Boolean> getPoints() {
        return this.points;
    }
}
