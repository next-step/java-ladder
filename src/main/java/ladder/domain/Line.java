package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final String LINE = "-----";
    private static final String LINE_DEFAULT = "     ";
    private static final String DELIMITER = "|";
    private List<Boolean> lineRow = new ArrayList<Boolean>();

    public Line(int size) {

        this(size, new MakeLineWithRandom());
    }

    public Line(int size, MakeLine makeLine) {

        boolean beforeLine = false;
        for (int index = 0; index < size - 1; index++) {
            Boolean line = makeLine.createLine(beforeLine);
            beforeLine = line;
            lineRow.add(line);
        }
    }

    public List<Boolean> getLineRow() {
        return lineRow;
    }

    @Override
    public String toString() {
        if (lineRow.isEmpty()) {
            return LINE_DEFAULT + DELIMITER;
        }

        return this.lineRow.stream()
                .map(line -> line ? LINE : LINE_DEFAULT)
                .collect(Collectors.joining(DELIMITER, LINE_DEFAULT + DELIMITER, DELIMITER));
    }
}
