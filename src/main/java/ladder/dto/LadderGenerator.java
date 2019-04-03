package ladder.dto;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public static Ladder createLadde(int height, int lineCount, List<Gamer> gamers, List<Reward> rewards) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            Line line = new Line(height);
            line.createRow();
            lines.add(line);
        }

        return new Ladder(lines, gamers, rewards);
    }
}
