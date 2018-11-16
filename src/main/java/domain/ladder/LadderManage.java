package domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderManage {
    private List<Player> players;
    private List<Line> lines;

    public LadderManage(String[] names, int ladderCount) {
        players = Arrays.stream(names).map(name -> new Player(name)).collect(Collectors.toList());
        lines = new LineCreation().getLines(ladderCount, players.size());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Line> getLines() {
        return lines;
    }
}
