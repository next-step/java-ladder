package net.chandol.ladder.v2.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Ladder {
    private static final String LINE_START_PADDING = "  ";
    private static final String BRIDGE_EXIST = "-----";
    private static final String BRIDGE_EMPTY = "     ";
    private static final String LINE_CHARACTER = "|";

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

    public String createColumnString(int row) {
        StringBuilder builder = new StringBuilder(LINE_START_PADDING);
        IntStream.range(0, players.size()).forEach(idx -> {
            builder.append(LINE_CHARACTER);

            String bridge = hasPoint(idx, row) ? BRIDGE_EXIST : BRIDGE_EMPTY;
            builder.append(bridge);
        });

        return builder.toString();
    }

    public List<String> createLadderString() {
        return IntStream.range(0, height)
                .mapToObj(this::createColumnString)
                .collect(Collectors.toList());
    }

    public String createPlayersString() {
        return players.stream()
                .map(Ladder::fixedLengthString)
                .collect(joining(" "));
    }

    private static String fixedLengthString(String player) {
        return StringUtils.center(player, 5);
    }
}
