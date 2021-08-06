package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public enum Line {
    INITLINE(false, "    |"),
    NONELINE(false, "     |"),
    ISLINE(true, "-----|");

    private final boolean isExist;
    private final String line;

    Line(boolean isExist, String line) {
        this.isExist = isExist;
        this.line = line;
    }

    public static List<Line> initLine() {
        List<Line> lines = new ArrayList<>();
        lines.add(Line.INITLINE);
        return lines;
    }

    public static List<String> makeLine(List<Line> lines) {
        List<String> list = new ArrayList<>();
        for(Line line : lines) {
            list.add(line.getLine());
        }
        return list;
    }

    public boolean isExist() {
        return isExist;
    }

    public String getLine() {
        return line;
    }

}
