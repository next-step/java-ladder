package ladder.dto;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class LadderResult {

    Map<Integer, Integer> permutation;

    private LadderResult(Map<Integer, Integer> permutation) {
        this.permutation = permutation;
    }

    public static LadderResult of(Map<Integer, Integer> permutation) {
        return new LadderResult(permutation);
    }

    public int resultByIndex(int index) {
        return Optional.ofNullable(permutation.get(index))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LadderResult)) {
            return false;
        }
        LadderResult that = (LadderResult) o;
        return Objects.equals(permutation, that.permutation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permutation);
    }

    @Override
    public String toString() {
        return "LadderResult{" +
                "permutation=" + permutation +
                '}';
    }
}
