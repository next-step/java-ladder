package domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Laddering {

    private Players players;
    private Lines lines;

    public Laddering(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public List<PlayResult> playerResult( LadderResult ladderResult) {
        List<PlayResult> playResults = new ArrayList<>();
        for(Player player : players.getPlayers()){
            playResults.add(new PlayResult(player, ladderResult.getResult(getLocation(players.getPlayerLocation(player.Name())))));
        }
        return playResults;
    }

    private int getLocation(int location) {
        int resultLocation = location;
        resultLocation = getResultLocation(resultLocation, lines);
        return resultLocation;
    }

    private int getResultLocation(int resultLocation, Lines lines) {
        for (LadderLine line : lines.getLine()) {
            System.out.println(Arrays.toString(line.getPoints().toArray()));
            resultLocation = line.move(resultLocation);
        }
        return resultLocation;
    }

    public Lines getLines() {
        return lines;
    }

    public Players getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laddering laddering = (Laddering) o;
        return Objects.equals(players, laddering.players) &&
                Objects.equals(lines, laddering.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, lines);
    }

    @Override
    public String toString() {
        return "Laddering{" +
                "players=" + players +
                ", lines=" + lines +
                '}';
    }
}
