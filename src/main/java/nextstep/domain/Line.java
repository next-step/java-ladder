package nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, boolean firstStart) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("2명이상 있어야 가능합니다.");
        }
        for (int i = 1; i < countOfPerson; i++) {
            points.add(createLine(i, firstStart));
        }
    }

    private boolean createLine(int i, boolean firstStart) {
        if (isFirstIndex(i, firstStart) || isBeforeLineTure(i)) {
            return true;
        }
        return false;
    }

    private boolean isBeforeLineTure(int i) {
        return i != 1 && !points.get(i - 2);
    }

    private static boolean isFirstIndex(int i, boolean firstStart) {
        return i == 1 && firstStart;
    }

    public List<Boolean> getLine() {
        return this.points;
    }

    public String getLineString() {
        StringBuilder sb = new StringBuilder();
        sb.append("     |");
        for (int i = 0; i < points.size(); i++) {
            createLine(sb, i);
        }
        sb.append("|");
        return sb.toString();
    }

    private void createLine(StringBuilder sb, int i) {
        sb.append(makeLine(points.get(i)));
        if (i < points.size() - 1) {
            sb.append("|");
        }
    }

    private String makeLine(Boolean point) {
        if (point) {
            return "-----";
        }
        return "     ";
    }
}
