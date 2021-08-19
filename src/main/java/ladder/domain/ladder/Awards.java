package ladder.domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Awards {

    public static final String COMMA = ",";

    private final List<Award> awards;

    private Awards(List<Award> awards) {
        this.awards = awards;
    }

    public static Awards from(String namesOfAwards) {
        return Arrays.stream(namesOfAwards.split(COMMA))
                .map(Award::new)
                .collect(collectingAndThen(toList(), Awards::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Awards awards1 = (Awards) o;
        return Objects.equals(awards, awards1.awards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(awards);
    }
}
