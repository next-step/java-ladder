package ladder.domain.dto;

import ladder.domain.ladder.Bar;

import java.util.List;

public class BarMatrixDto {
    private final List<List<Bar>> barMatrix;

    public BarMatrixDto(List<List<Bar>> barMatrix) {
        this.barMatrix = barMatrix;
    }

    public List<List<Bar>> getBarMatrix() {
        return barMatrix;
    }
}
