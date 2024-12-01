import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final Players players;
    private final Lines lines;

    public Ladder(String[] playerNames, List<Line> lines) {
        this(Arrays.asList(playerNames), lines);
    }

    public Ladder(List<String> players, List<Line> lines) {
        this.players = new Players(players.stream().map(Player::new).collect(Collectors.toList()));
        this.lines = new Lines(lines);
    }

    public int height() {
        return this.lines.height();
    }

    public int travel(int playerNumber) {
        Step step = new Step(DotCache.get(playerNumber * 2, 0), 0, true);

        while (step.lowerHeightThan(height())) {
            step = step.forward(this.lines.heightAt(step.height()));
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

        this.players.appendPlayers(sb);
        sb.append("\n");
        this.lines.appendLines(sb);

        return sb.toString();
    }
}
