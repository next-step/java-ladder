package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lines = new ArrayList<>();

    public Lines(int playerCount, int ladderHeight) {
        for(int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(playerCount));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
