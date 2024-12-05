import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final Players players;
    private final Results results;
    private final Lines lines;

    public Ladder(String[] playerNames, String[] results, List<Line> lines) {
        this(Arrays.asList(playerNames), Arrays.asList(results), lines);
    }

    public Ladder(List<String> players, List<String> results, List<Line> lines) {
        this.players = new Players(players.stream().map(Player::new).collect(Collectors.toList()));
        this.results = new Results(results.stream().map(Result::new).collect(Collectors.toList()));
        this.lines = new Lines(lines);
    }

    public int height() {
        return this.lines.height();
    }

    public List<TravelResult> travelAll() {
        List<TravelResult> travelResults = new ArrayList<>();

        for (int i = 0; i < this.players.size(); i++) {
            travelResults.add(this.travel(i));
        }

        return travelResults;
    }

    public TravelResult travel(String playerName) {
        int playerNumber = this.players.playerPosition(playerName);

        if (playerNumber == Players.INVALID_PLAYER_NAME) {
            return new TravelResult(playerName, "INVALID");
        }

        return this.travel(this.players.playerPosition(playerName));
    }

    public TravelResult travel(int playerNumber) {
        Step step = new Step(DotCache.get(playerNumber * 2, 0), 0, true);

        while (step.lowerHeightThan(height())) {
            step = step.forward(this.lines.heightAt(step.height()));
        }

        return new TravelResult(this.players.nameAt(playerNumber), this.results.get(step.resultNumber()));
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
        this.results.appendResults(sb);

        return sb.toString();
    }
}
