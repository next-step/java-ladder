package laddarGame.dto;

import java.util.List;
import java.util.Objects;

public class LineDto {

    private final List<Boolean> line;

    public LineDto(List<Boolean> line) {
        this.line = line;
    }

    public LineDto(boolean first, boolean second, boolean third, boolean fourth) {
        this.line = List.of(first, second, third, fourth);
    }

    public List<Boolean> getLine() {
        return line;
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
