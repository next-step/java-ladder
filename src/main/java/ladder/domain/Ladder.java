package ladder.domain;

import ladder.factory.PointFactory;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder(int countOfLine, int countOfPerson, PointFactory factory) {
        for (int i = 0; i < countOfLine; i++) {
            this.lines.add(new Line(countOfPerson, factory));
        }
    }

    public List<Line> lines() {
        return this.lines;
    }

}
