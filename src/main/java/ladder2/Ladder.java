package ladder2;

import java.util.HashMap;
import java.util.List;

import ladder.InputResult;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public LadderResult run(Players players, InputResult inputResult) {
        HashMap<String, String> ladderResult = new HashMap<>();

        for (int startPoint = 0; startPoint < players.size(); startPoint++) {
            int endPoint = move(startPoint);
            ladderResult.put(players.get(startPoint), inputResult.get(endPoint));
        }
        return new LadderResult(ladderResult);
    }

    public int move(int position) {
        int current = position;
        for (Line line : lines) {
            current = line.move(current);
        }
        return current;
    }

    public List<Line> getLines() {
        return lines;
    }
}
