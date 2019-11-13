package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final int MIN_SIZE = 0;
    private static final int LAST_INDEX = -1;
    private static final String LADDER_VERTICAL_CHARACTER = "|";
    private static final String LADDER_LINE_STRING = "-----";
    private static final String LADDER_NO_LINE_STRING = "     ";

    private CreatingStrategy creatingStrategy;
    private List<Boolean> points = new ArrayList<>();

    public Line(CreatingStrategy creatingStrategy, int width) {
        this.creatingStrategy = creatingStrategy;
        createLine(width);
    }

    private void createLine(int width) {
        for (int i = 0; i < width; i++) {
            points.add(getCurrentPoint() ? false : createPoint());
        }
    }

    private boolean getCurrentPoint() {
        if (points.size() == MIN_SIZE) {
            return false;
        }

        return points.get(points.size() + LAST_INDEX);
    }

    private Boolean createPoint() {
        return creatingStrategy.isCreatable();
    }

    public String drawLine() {
        String lineFormat = LADDER_VERTICAL_CHARACTER;
        lineFormat += points.stream()
                .map(this::decideLine)
                .map(this::addVerticalCharacter)
                .collect(Collectors.joining());

        return lineFormat;
    }

    private String addVerticalCharacter(String pointValue) {
        return pointValue + LADDER_VERTICAL_CHARACTER;
    }

    private String decideLine(Boolean pointValue) {
        return pointValue ? LADDER_LINE_STRING : LADDER_NO_LINE_STRING;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean isExist(int index) {
        if (index < 0 || index >= points.size()) {
            return false;
        }

        return points.get(index);
    }
}
