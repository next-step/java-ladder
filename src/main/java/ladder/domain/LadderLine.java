package ladder.domain;

import ladder.exception.InvalidRopeException;

import java.util.List;
import java.util.stream.IntStream;

public class LadderLine {
    private final List<Rope> ropes;

    public LadderLine(List<Rope> ropes) {
        validateContinuousRope(ropes);
        this.ropes = ropes;
    }

    private void validateContinuousRope(List<Rope> ropes) {
        boolean valid = IntStream.range(0, ropes.size() - 1)
                .noneMatch(iRopeIndex ->
                        ropes.get(iRopeIndex).exist() && ropes.get(iRopeIndex + 1).exist()
                );
        if (!valid)
            throw new InvalidRopeException("이어지는 로프가 있습니다.");
    }

    public int ropeSize() {
        return ropes.size();
    }
}
