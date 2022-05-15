package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final String STICK = "|";
    private static final Random RANDOM = new Random();
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String EDGE = "-----";
    private static final String EMPTY = "     ";

    private List<Boolean> points = new ArrayList<>();

    public Line(Members members) {
        this(members.size());
    }

    private Line(int size) {
        for (int i = 0; i < size - 1; i++) {
            setPoint(i);
        }
    }

    Line(List<Boolean> points) {
        this.points = points;
    }

    public String getPoint() {
        StringBuilder stringBuilder = new StringBuilder();
        this.points.stream()
                .map(this::getEdgeOrEmpty)
                .forEach(stringBuilder::append);

        stringBuilder.append(STICK);
        stringBuilder.append(LINE_SEPARATOR);

        return stringBuilder.toString();
    }

    private void setPoint(int i) {
        boolean nextBoolean = RANDOM.nextBoolean();
        if (this.points.isEmpty()) {
            this.points.add(nextBoolean);
            return;
        }

        if (previousHasEdge(i)) {
            this.points.add(false);
            return;
        }

        this.points.add(nextBoolean);
    }

    private Boolean previousHasEdge(int i) {
        return this.points.get(i - 1);
    }

    private String getEdgeOrEmpty(Boolean point) {
        if (point) {
            return STICK + EDGE;
        }

        return STICK + EMPTY;
    }
}
