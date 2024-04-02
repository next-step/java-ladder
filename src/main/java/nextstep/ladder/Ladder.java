package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfPerson) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }

        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
