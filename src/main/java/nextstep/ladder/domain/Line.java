package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final String STICK = "|";
    private static final Random RANDOM = new Random();
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String EDGE = "-----";
    private static final String EMPTY_EDGE = "     ";

    private final List<Boolean> points = new ArrayList<>();

    public Line(Members members) {
        this(members.size());
    }

    private Line(int size) {
        for (int i = 0; i < size - 1; i++) {
            setPoint(i);
        }
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

    public void print() {
        this.points.stream()
                .map(this::getEdgeOrEmpty)
                .forEach(System.out::print);

        System.out.print(STICK);
        System.out.print(LINE_SEPARATOR);
    }

    private String getEdgeOrEmpty(Boolean point) {
        if (point) {
            return STICK + EDGE;
        }

        return STICK + EMPTY_EDGE;
    }
}
