package domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderManage {
    private List<Player> players;

    private List<Lines> lines;

    LadderManage(String[] names, List<Line> lines) {
        this.players = Arrays.stream(names).map(name -> new Player(name)).collect(Collectors.toList());
        this.lines = new LineCreation().getLines(lines);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Lines> getLines() {
        return lines;
    }
}
