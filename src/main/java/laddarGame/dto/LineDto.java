package laddarGame.dto;

import java.util.List;
import java.util.Objects;

public class LineDto {

    private List<Boolean> line;

    public LineDto(List<Boolean> line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineDto lineDto = (LineDto) o;
        return Objects.equals(line, lineDto.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
