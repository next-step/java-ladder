package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lines {
    private List<Line> lines = new ArrayList<>();

    public Lines(int person, int height) {
        for (int i = 0; i < height; i ++) {
            lines.add(new Line(person));
        }
    }

    public Iterator<Line> getIterator() {
        return lines.iterator();
    }
}
