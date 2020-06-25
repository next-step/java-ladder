package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderPrize {
    private final String result;

    private LadderPrize(String result) {
        this.result = result;
    }

    public static LadderPrize of(String result) {
        return new LadderPrize(result);
    }

    public static List<LadderPrize> of(List<String> result) {
        return result.stream().map(LadderPrize::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPrize that = (LadderPrize) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
