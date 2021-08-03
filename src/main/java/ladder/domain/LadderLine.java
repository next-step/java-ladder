package ladder.domain;

import ladder.exception.InvalidRopeException;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LadderLine implements Iterable<Rope> {
    private final List<Rope> ropes;

    public LadderLine(List<Rope> ropes) {
        validateContinuousRope(ropes);
        this.ropes = ropes;
    }

    private void validateContinuousRope(List<Rope> ropes) {
        boolean valid = IntStream.range(0, ropes.size() - 1)
                .noneMatch(iRopeIndex ->
                        ropes.get(iRopeIndex).isPresent() && ropes.get(iRopeIndex + 1).isPresent()
                );
        if (!valid)
            throw new InvalidRopeException("이어지는 로프가 있습니다.");
    }

    public int ropeSize() {
        return ropes.size();
    }

    @Override
    public Iterator<Rope> iterator() {
        return ropes.iterator();
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        LadderLine ropes1 = (LadderLine) compareValue;
        return Objects.equals(ropes, ropes1.ropes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ropes);
    }
}
