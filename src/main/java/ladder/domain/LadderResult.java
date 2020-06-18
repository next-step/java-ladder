package ladder.domain;

import java.util.Objects;

public class LadderResult {

    public String result;
    public Position position;

    public LadderResult(String result, int position) {
        this.result = result;
        this.position = new Position(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(result, that.result) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, position);
    }
}
