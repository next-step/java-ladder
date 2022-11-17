package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Player> playerList = new ArrayList<>();
    private final List<Line> lines = new ArrayList<>();

    public Ladder(List<String> nameList, int height) {
        nameList.forEach((name) -> this.playerList.add(new Player(name)));

        IntStream.range(0, height)
                .forEach((i) -> lines.add(new Line(nameList.size())));
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
