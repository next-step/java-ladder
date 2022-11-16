package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Player> playerList = new ArrayList<>();
    private final List<Line> lines = new ArrayList<>();

    public Ladder(List<String> nameList, int height) {
        for (String name : nameList) {
            this.playerList.add(new Player(name));
        }

        for (int i = 0; i < height; i++) {
            lines.add(new Line(nameList.size()));
        }
    }

    public List<String> names() {
        return playerList.stream()
                .map(Player::name)
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return lines;
    }
}
