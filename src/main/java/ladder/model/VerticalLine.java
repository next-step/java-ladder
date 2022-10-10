package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class VerticalLine {

    private final List<LineUnit> lineUnits;

    public VerticalLine(List<LineUnit> lineUnits) {
        this.lineUnits = lineUnits;
    }

    public static VerticalLine mapHorizontalLineToVertical(List<HorizontalLine> horizontalLine, int userIndex) {
        List<LineUnit> verticalLine = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < horizontalLine.size(); lineIndex++) {
            HorizontalLine line = horizontalLine.get(lineIndex);
            LineUnit lineUnit = line.getUnits().get(userIndex);
            verticalLine.add(lineUnit);
        }
        return new VerticalLine(verticalLine);
    }

    public List<LineUnit> getLineUnits() {
        return lineUnits;
    }

}
