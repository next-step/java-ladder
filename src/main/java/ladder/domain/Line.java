package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> line;

    public Line(int countOfPerson) {
        this.line = new ArrayList<>(countOfPerson);
    }

    public List<Boolean> getLine() {
        return line;
    }
}
