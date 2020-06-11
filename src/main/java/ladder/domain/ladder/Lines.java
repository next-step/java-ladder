package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Lines {

    private final List<Line> lineList;

    private Lines(final List<Line> lineList){
        this.lineList = lineList;
    }

    public static Lines create(final List<Line> lineList) {
        validate(lineList);
        return new Lines(lineList);
    }

    public List<Line> getLineList() {
        return Collections.unmodifiableList(lineList);
    }

    private static void validate(List<Line> lineList) {
        if (lineList == null) {
            throw new IllegalArgumentException("lineList 의 값이 null 입니다.");
        }
    }
}
