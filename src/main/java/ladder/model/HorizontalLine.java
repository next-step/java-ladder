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

    public void validate(int userSize) {
        if (userSize != this.size()) {
            throw new IllegalArgumentException("유효하지 않은 행 라인입니다.");
        }
    }
}
