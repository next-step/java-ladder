package ladder;

import ladder.domain.Line;

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
        lineList.add(new Line(pointListSize));
    }

    public int size() {
        return lineList.size();
    }

    public List<Line> lineList() {
        return Collections.unmodifiableList(new ArrayList<>(lineList));
    }
}
