package ladder.result;

import java.util.List;
import java.util.Objects;
import ladder.ladder.Position;

public class Awards {

    private final List<Award> awards;

    public Awards(List<Award> awards) {
        this.awards = awards;
    }

    public Award getAward(Position position) {
        return awards.get(position.getPosition());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Awards awards1 = (Awards) o;
        return Objects.equals(awards, awards1.awards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(awards);
    }
}
