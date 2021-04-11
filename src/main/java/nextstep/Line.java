package nextstep;

import nextstep.constant.Constant;

import java.util.ArrayList;
import java.util.List;

import static nextstep.constant.Constant.*;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson * PER_DOT; i++) {
            points.add(false);
        }
    }

    public void mark(int target) {
        for (int i = target * PER_DOT; i < target * PER_DOT + PER_DOT; i++) {
            points.set(i, true);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public String lineString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < points.size(); i++) {
            if (i % PER_DOT == 0) {
                stringBuilder.append("|");
            }
            if (points.get(i)) {
                stringBuilder.append(HORIZON);
            } else {
                stringBuilder.append(EMPTY);
            }
            if (i == points.size() - 1) {
                stringBuilder.append("|");
            }
        }
        return stringBuilder.toString();
    }
}
