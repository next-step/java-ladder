package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private List<Line> lines = new ArrayList<>();

    public LadderGame(int height, int countOfPerson) {
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
