package ladderstep4.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder2 {
    private final List<LadderLine> ladderLines;

    public Ladder2(int playerCount, int height) {
        this(new PlayerCount(playerCount), new Height(height));
    }

    public Ladder2(PlayerCount playerCount, Height height) {
        this(init(playerCount, height));
    }

    public Ladder2(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    private static List<LadderLine> init(PlayerCount playerCount, Height height) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            ladderLines.add(new LadderLine(playerCount));
        }
        return ladderLines;
    }

    public PlayResult play() {
        PlayResult playResult = new PlayResult();
        for (int i = 0; i < ladderLines.get(0).size(); i++) {
            Position start = new Position(i);
            playResult.put(start, findEndPosition(start));
        }
        return playResult;
    }

    private Position findEndPosition(Position position) {
        for (LadderLine ladderLine : ladderLines) {
            position = ladderLine.move(position);
        }
        return position;
    }
}
