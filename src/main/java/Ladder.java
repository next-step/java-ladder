import java.util.Arrays;
import java.util.List;

public class Ladder {
    private final List<String> players;
    private final List<Line> lines;

    public Ladder(String[] playerNames, List<Line> lines) {
        this.players = Arrays.asList(playerNames);
        this.lines = lines;
    }

    public int height() {
        return this.lines.size();
    }

    public int travel(int playerNumber) {
        Step step = new Step(DotCache.get(playerNumber * 2, 0), true);

        while (step.lowerHeightThan(height())) {
            step = step.forward(this.lines.get(step.getDotY()));
        }

        return step.playerNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;

        return this.lines.equals(ladder.lines);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        appendPlayers(sb);

        sb.append("\n");

        for (Line line : lines) {
            sb.append(line.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    private void appendPlayers(StringBuilder sb) {
        for (String playerName : this.players) {
            sb.append(Constants.PADDING);
            sb.append(playerName);
            sb.append(" ".repeat(Math.max(0, 5 - playerName.length())));
        }
    }
}
