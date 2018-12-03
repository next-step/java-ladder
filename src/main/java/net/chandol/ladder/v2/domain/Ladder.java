package net.chandol.ladder.v2.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Ladder {
    private List<Line> lines;
    private List<String> players;
    private int height;

    public Ladder(List<String> players, int height, LinesGenerator linesGenerator) {
        this.players = players;
        this.height = height;
        this.lines = linesGenerator.generate(players.size(), height);
    }

    public boolean hasPoint(int column, int row) {
        Line line = lines.get(column);
        return line.hasPoint(row);
    }

    public void drawColumn(int row) {
        StringBuilder builder = new StringBuilder("  ");
        for (int idx = 0; idx < players.size(); idx++) {
            builder.append("|");

            String bridge = hasPoint(idx, row) ? "-----" : "     ";
            builder.append(bridge);
        }

        System.out.println(builder.toString());
    }

    public void drawLadder() {
        IntStream.range(0, height).forEach(r -> drawColumn(r));
    }

    public void drawPlayers() {
        String p = players.stream().map(Ladder::fixedLengthString).collect(joining(" "));
        System.out.println(p);
    }

    public static String fixedLengthString(String player) {
        return StringUtils.center(player, 5);
    }
}
