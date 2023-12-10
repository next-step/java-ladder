package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private List<Line> values = new ArrayList<>();

    public Lines(int countOfPerson, int countOfLadder) {
        for (int i = 0; i < countOfLadder; i++) {
            values.add(new Line(countOfPerson));
        }
    }

    public int size() {
        return this.values.size();
    }

    public Line getLine(int index) {
        return this.values.get(index);
    }
}
