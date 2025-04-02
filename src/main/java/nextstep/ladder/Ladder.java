package nextstep.ladder;

import java.util.List;

public class Ladder {
    private final List<List<Boolean>> lines;

    public Ladder(List<List<Boolean>> lines) {
        this.lines = lines;
    }

    public void go() {
        int y = 0, x = 0;
        while (y < lines.get(0).size()) {
            if (x < lines.size() && lines.get(x).get(y)) {
                x++;
            }
            if (x > 0 && lines.get(x - 1).get(y)) {
                x--;
            }
            y++;
        }
    }
}
