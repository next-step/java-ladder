package ladder.domain;

import ladder.drawable.Drawable;
import ladder.drawable.RandomDraw;
import ladder.dto.GameInfo;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int height;
    private final List<Line> lines;

    public Ladder(GameInfo gameInfo, int height) {
        this.height = height;
        this.lines = drawLines(gameInfo.getPlayers().count(), new RandomDraw());
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    private List<Line> drawLines(int playerCount, Drawable drawable) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(playerCount, drawable));
        }
        return lines;
    }
}
