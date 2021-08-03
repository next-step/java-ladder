package ladder.domain;

import ladder.exception.InvalidRopeException;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder implements Iterable<LadderLine> {
    private final List<LadderLine> ladderLines;

    private static final Random random = new Random();

    public Ladder(List<LadderLine> ladderLines) {
        validateRopeSizeOfLadderLine(ladderLines);

        this.ladderLines = ladderLines;
    }

    private void validateRopeSizeOfLadderLine(List<LadderLine> ladderLines) {
        boolean valid = ladderLines.stream()
                .map(LadderLine::ropeSize)
                .distinct()
                .count() == 1;

        if (!valid) {
            throw new InvalidRopeException("로프의 갯수가 다른 줄이 존재합니다.");
        }
    }

    public static Ladder randomGenerate(int ropeSize, int lineHeight) {
        // 사다리 자동 생성 메서드
        // 줄당 로프 갯수와 총 사다리 높이를 입력하면 랜덤으로 사다리를 생성 합니다.
        List<LadderLine> ladderLines = IntStream.rangeClosed(0, lineHeight)
                .mapToObj(i -> newRandomLadderLine(ropeSize))
                .collect(Collectors.toList());

        return new Ladder(ladderLines);
    }

    private static LadderLine newRandomLadderLine(int ropeSize) {
        // 사다리 라인 자동 생성 메서드
        // 양수와 짝수 중 하나를 정한 후 정한 룰에 맞게 로프를 랜덤으로 생성 합니다.
        int ropePosition = random.nextInt(2);
        List<Rope> ropes = IntStream.range(0, ropeSize - 1)
                .mapToObj(iRopeCount ->
                        newRandomRope(ropePosition, iRopeCount)
                )
                .collect(Collectors.toList());

        return new LadderLine(ropes);
    }

    private static Rope newRandomRope(int ropePosition, int ropeCount) {
        return ropeCount % 2 == ropePosition ?
                Rope.of(random.nextInt(100) < 80) : Rope.empty();
    }

    @Override
    public Iterator<LadderLine> iterator() {
        return this.ladderLines.iterator();
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        Ladder that = (Ladder) compareValue;
        return Objects.equals(ladderLines, that.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
