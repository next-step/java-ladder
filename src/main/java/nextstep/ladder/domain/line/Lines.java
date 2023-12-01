package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {
    private List<Line> lineList = new ArrayList<>();
    private int highCount;

    public Lines() {}

    public Lines(int highCount) {
        this.highCount = highCount;
    }

    public void addLine(Line line) {
        lineList.add(line);
    }

    public final List<Line> getLineList() {
        return Collections.unmodifiableList(lineList);
    }
}
