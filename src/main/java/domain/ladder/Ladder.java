package domain.ladder;

import util.BridgeGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> ladder;

    public Ladder(int ladderHeight, int userCount, BridgeGenerator bridgeGenerator) {
        ladder = generate(ladderHeight, userCount, bridgeGenerator);
    }

    public List<Line> generate(int ladderHeight, int userCount, BridgeGenerator bridgeGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(bridgeGenerator).generate(userCount));
        }
        return lines;
    }

    public int size() {
        return ladder.size();
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
