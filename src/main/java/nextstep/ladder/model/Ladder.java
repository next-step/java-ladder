package nextstep.ladder.model;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> lines;
    private List<Reward> rewards;

    public Ladder(List<Line> lines, List<Reward> rewards) {
        this.lines = lines;
        this.rewards = rewards;
    }

    public Reward doPlay(int start) {
        int x = start;
        int y = 0;
        int height = lines.get(0)
                .getPoints()
                .size();

        while (y < height) {
            Line line = lines.get(x);
            x = line.moveHorizontal(x, y);

            y++;
        }

        return rewards.get(x);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
