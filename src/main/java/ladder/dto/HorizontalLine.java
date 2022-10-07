package ladder.dto;

import ladder.model.LineUnit;

import java.util.List;

public class HorizontalLine {

    private final List<LineUnit> units;

    public HorizontalLine(List<LineUnit> units) {
        this.units = units;
    }

    public List<LineUnit> getUnits() {
        return units;
    }
}
