package ladder.dto;

import java.util.List;

public class PositionsDto {
    private final List<Integer> positions;

    public PositionsDto(List<Integer> positions) {
        this.positions = positions;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
