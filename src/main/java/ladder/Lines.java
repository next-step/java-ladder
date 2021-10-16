package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private final List<Line> lineList = new ArrayList<>();

    public Lines(int ladderHeight, int countOfPerson) {
        for (int i = 0 ; i < ladderHeight; i++) {
            Line line = new Line(countOfPerson);
            lineList.add(line);
        }
    }

    public List<Line> getLineList() {
        return Collections.unmodifiableList(lineList);
    }

    public int getLineHeight() {
        return lineList.size();
    }
}
