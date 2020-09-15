package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private List<Boolean> lines;

    public Line(int userCount) {
        lines = new LineGenerator(userCount).generateLine();
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(lines);
    }

    private boolean isLeft(int position) {
        return lines.get(position);
    }

    private boolean isRight(int position) {
        return position + 1 < lines.size()
                && lines.get(position + 1);
    }

    public int move(int position) {
        if(isLeft(position)) {
            return --position;
        }
        if(isRight(position)) {
            return ++position;
        }
        return position;
    }
}
