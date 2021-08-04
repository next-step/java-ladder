package ladder.domain;

import ladder.exception.InvalidRopeException;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLine implements Iterable<Rope> {
    private static final int FIRST_ROPE_INDEX = 0;
    private final List<Rope> ropes;

    private LadderLine(List<Rope> ropes) {
        validateContinuousRope(ropes);
        this.ropes = ropes;
    }

    public static LadderLine of(List<Rope> ropes) {
        return new LadderLine(ropes);
    }

    public static LadderLine randomGenerate(int ropeSize) {
        List<Rope> ropes = Stream.iterate(Rope.empty(), Rope::next)
                .limit(ropeSize)
                .collect(Collectors.toList());

        return new LadderLine(ropes);
    }

    private void validateContinuousRope(List<Rope> ropes) {
        boolean valid = IntStream.range(0, ropes.size() - 1)
                .noneMatch(iRopeIndex ->
                        ropes.get(iRopeIndex).isPresent() && ropes.get(iRopeIndex + 1).isPresent()
                );
        if (!valid) {
            throw new InvalidRopeException("이어지는 로프가 있습니다.");
        }
    }

    public int ropeSize() {
        return ropes.size();
    }

    public MoveDirection moveDirection(int ropeIndex) {
        // 로프의 방향은 왼쪽으로만 존재한다.
        // 로프가 오른쪽에 존재한다면 오른쪽으로 이동해야 하고, 현재 위치에 존재한다면 왼쪽으로 이동해야 한다.
        // 하나의 로프로 왼쪽과 오른쪽 모두 이동할 수 있다.
        if (ropeIndex > FIRST_ROPE_INDEX && isLeftMovable(ropeIndex)) {
            return MoveDirection.LEFT;
        }
        if (ropeIndex < ropes.size() - 1 && isRightMovable(ropeIndex)) {
            return MoveDirection.RIGHT;
        }
        return MoveDirection.NOT;
    }

    private boolean isLeftMovable(int ropeIndex) {
        return this.ropes.get(ropeIndex).isPresent();
    }

    private boolean isRightMovable(int ropeIndex) {
        return this.ropes.get(ropeIndex + 1).isPresent();
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
