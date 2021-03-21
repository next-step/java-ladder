package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineList {

    private final List<Line> lineList = new ArrayList<>();

    public void addBulk(int size, int pointListSize) {
        for (int i = 0; i < size; i++) {
            add(pointListSize);
        }
    }

    private void add(int pointListSize) {
        lineList.add(Line.random(pointListSize));
    }

    public void add(List<Point> pointList) {
        lineList.add(Line.of(pointList));
    }

    public int size() {
        return lineList.size();
    }

    public List<Line> lineList() {
        return Collections.unmodifiableList(new ArrayList<>(lineList));
    }
}
