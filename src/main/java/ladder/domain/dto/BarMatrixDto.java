package ladder.domain.dto;

import java.util.List;

public class BarMatrixDto {
    private final List<List<Boolean>> barMatrix;

    public BarMatrixDto(List<List<Boolean>> barMatrix) {
        this.barMatrix = barMatrix;
    }

    public List<List<Boolean>> getBarMatrix() {
        return barMatrix;
    }
}
