package my.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    public static final int FIRST_LINE = 0;
    public static final int PREVIOUS_NUMBER = 1;
    public static final int SECOND_VERTICAL = 2;
    public static final int PREVIOUS_BRIDGE = 2;
    public static final int LAST_VERTICAL = 2;
    public static final int LAST_BRIDGE = 2;

    private final List<Line> lines;
    private final Users users;
    private final int height;

    public Ladder(Users users, int height) {
        lines = new ArrayList<>();
        this.users = users;
        this.height = height;

        build(users);
        balance();
    }

    private void build(Users users) {
        IntStream.range(Line.ZERO, height)
                .forEach(i -> lines.add(new Line(users.getUsers().size())));
    }

    private void balance() {
        IntStream.range(FIRST_LINE, height)
                .forEach(i -> IntStream.range(FIRST_LINE, lines.get(i).getPoints().size())
                        .forEach(j -> {
                            if (isNoBridgeBetweenLines(i, j)) {
                                buildBridge(i, j);
                                destorySideBridges(i, j);
                            }
                        }));
    }

    private void buildBridge(int i, int j) {
        lines.get(i).getPoints().remove(j);
        lines.get(i).getPoints().add(j, Symbol.BRIDGE);
    }

    private void destorySideBridges(int i, int j) {
        if (j > SECOND_VERTICAL) {
            lines.get(i).getPoints().remove(j - PREVIOUS_BRIDGE);
            lines.get(i).getPoints().add(j - PREVIOUS_BRIDGE, Symbol.NONE);
        }
        if (j < lines.get(i).getPoints().size() - LAST_VERTICAL) {
            lines.get(i).getPoints().remove(j + LAST_BRIDGE);
            lines.get(i).getPoints().add(j + LAST_BRIDGE, Symbol.NONE);
        }
    }

    private boolean isNoBridgeBetweenLines(int i, int j) {
        return i != FIRST_LINE
                && lines.get(i).getPoints().get(j) == Symbol.NONE
                && lines.get(i - PREVIOUS_NUMBER).getPoints().get(j) == Symbol.NONE;
    }

    public List<Line> getLines() {
        return lines;
    }

    public String result(String player) {
        Point startPoint = users.getUserPoint(player);

        lines.forEach(line ->
                line.getPoints().stream()
                        .map(Symbol::getSymbol)
                        .collect(Collectors.joining())
        );

        return "";
    }
}
