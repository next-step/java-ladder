package laddarGame.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LineDto {

    private List<Boolean> line;

    public LineDto(List<Boolean> line) {
        this.line = line;
    }

    public LineDto(boolean first, boolean second, boolean third, boolean fourth) {
        this.line = Arrays.asList(first, second, third, fourth);
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
