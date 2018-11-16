package domain.ladder;

import java.util.List;

public class Laddering {
    private List<Player> players;
    private List<Line> lines;

    public Laddering(List<Player> players, List<Line> lines) {
        this.players = players;
        this.lines = lines;
    }

    int showResult(Player playerName) {
        int location = players.indexOf(playerName);
        System.out.println("player : " + location);
        for(Line line : lines){
            location = line.Move(location);
        }
        return location;
    }
}
