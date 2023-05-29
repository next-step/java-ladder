package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Players players;
    private final LadderHeight height;
    private List<LadderLine> lines;

    public Ladder(Players players, Integer height) {
        this(players, new LadderHeight(height));
    }

    private Ladder(Players players, LadderHeight height) {
        this.players = players;
        this.height = height;
    }

    public void operate() {
        List<LadderLine> lines =new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(LadderLine.generate(players.count()));
        }
        this.lines = lines;
    }

    public LadderHeight getHeight() {
        return height;
    }

    public List<LadderLine> getLines() {
        return lines;
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }
}
