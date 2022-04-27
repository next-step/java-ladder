package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladders {

    private List<Line> lines = new ArrayList<>();

    public Ladders(int countOfPerson, int maxHeight) {
        for (int i = 0; i < maxHeight; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
