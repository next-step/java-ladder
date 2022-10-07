package ladder.model;

import java.util.List;

public class HorizontalLine {

    private final List<LineUnit> units;

    public HorizontalLine(List<LineUnit> units) {
        this.units = units;
    }

    public List<LineUnit> getUnits() {
        return units;
    }

    public int size() {
        return this.units.size();
    }
}
