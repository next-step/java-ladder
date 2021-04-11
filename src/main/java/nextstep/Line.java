package nextstep;

import java.util.ArrayList;
import java.util.List;

import static nextstep.constant.Constant.*;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            points.add(false);
        }
    }

    public void mark(int target) {
        points.set(target, true);
    }

    public void mark() {
        for (int i = 0; i < points.size(); i++) {
            points.set(i, RAND.nextBoolean());
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public String lineString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < points.size(); i++) {
            stringBuilder.append("|");
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
