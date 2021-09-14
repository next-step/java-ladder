package step2.domain;

import step2.dto.Players;

import java.util.List;

public class Ladder {
    private final Players players;
    private final Lines lines;

    public Ladder(Players players, List<Line> lineList) {
        this.players = players;
        this.lines = new Lines(lineList);
    }

    public Ladder(Players players, int height) {
        this.players = players;
        this.lines = new Lines(players.size(), height);
    }

    public Results play() {
        return lines.play(this.players.size());
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(players.print());
        stringBuilder.append("\n");
        stringBuilder.append(lines.print());
        return stringBuilder.toString();
    }


    @Override
    public String toString() {
        return "Ladder{" +
                "names=\n" + players + "\n" +
                ", lines=\n" + lines +
                '}';
    }
}
