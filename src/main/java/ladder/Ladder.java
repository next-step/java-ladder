package ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int playerSize) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < height; index++) {
            lines.add(new Line(playerSize - 1, new RandomLineGenerator()));
        }
        this.lines = lines;
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public LadderResult run(Players players, InputResult inputResult) {
        HashMap<String, String> ladderResult = new HashMap<>();

        for (int startPoint = 0; startPoint < players.size(); startPoint++) {
            int endPoint = runPerPerson(startPoint);
            ladderResult.put(players.get(startPoint), inputResult.get(endPoint));
        }
        return new LadderResult(ladderResult);
    }

    int runPerPerson(int startPoint) {
        int endPoint = startPoint;
        for (Line line : lines) {
            endPoint += line.findNextPoint(endPoint);
        }
        return endPoint;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Ladder))
            return false;
        Ladder ladder = (Ladder)o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lines);
    }
}
