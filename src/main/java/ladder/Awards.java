package ladder;

import java.util.List;
import java.util.Objects;

public class Awards {

    private final List<Award> awards;

    public Awards(List<Award> awards) {
        this.awards = awards;
    }

    public static Awards of(List<Award> awards) {
        return new Awards(awards);
    }

    public List<Award> getAwards() {
        return awards;
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
