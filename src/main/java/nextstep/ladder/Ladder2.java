package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder2 {
    private List<Line2> lines;

    public Ladder2(int countOfPerson, int height) {
        createLines(countOfPerson, height);
    }

    private void createLines(int countOfPerson, int height) {
        lines = new ArrayList<Line2>();

        for(int i = 0; i < height; i++) {
            lines.add(new Line2(countOfPerson));
        }
    }

    public int move(int position) {
        int index = position;
        for(Line2 line : lines) {
            index = line.move(index);
        }
        return index;
    }

}
