package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {

    private final Players players;
    private final List<LadderLine> ladderLines = new ArrayList<>();

    public Ladder(Players players, LadderHeight ladderHeight) {
        Objects.requireNonNull(players, "players는 null일 수 없습니다.");
        Objects.requireNonNull(ladderHeight, "ladderHeight은 null일 수 없습니다.");

        this.players = players;
        drawLines(ladderHeight);
    }

    private void drawLines(LadderHeight ladderHeight) {
        for (int i = 0, playersCount = players.size(); i < ladderHeight.getHeight(); i++) {
            ladderLines.add(new LadderLine(playersCount));
        }
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }
}
