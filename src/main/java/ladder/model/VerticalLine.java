package ladder.model;

import java.util.List;

public class VerticalLine {

    private final List<LineUnit> lineUnits;

    public VerticalLine(List<LineUnit> lineUnits) {
        this.lineUnits = lineUnits;
    }

    public List<LineUnit> getLineUnits() {
        return lineUnits;
    }
}
