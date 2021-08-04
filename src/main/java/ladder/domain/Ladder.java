package ladder.domain;

import ladder.dto.LadderRandomGenerateRequest;
import ladder.dto.LadderRequest;
import ladder.exception.InvalidPrizeException;
import ladder.exception.InvalidRopeException;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder implements Iterable<LadderLine> {
    private final List<LadderLine> ladderLines;
    private final List<Prize> prizes;

    private Ladder(List<LadderLine> ladderLines, List<Prize> prizes) {
        validateRopeSizeOfLadderLine(ladderLines);
        validatePrizeSize(prizes, ladderLines);

        this.ladderLines = ladderLines;
        this.prizes = prizes;
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

    private void validatePrizeSize(List<Prize> prizes, List<LadderLine> ladderLines) {
        if (Objects.isNull(prizes)
                || prizes.size() != ladderLines.get(0).ropeSize()) {
            throw new InvalidPrizeException("상품의 갯수가 로프의 갯수와 다릅니다.");
        }
    }

    public static Ladder randomGenerate(LadderRandomGenerateRequest request) {
        // 사다리 자동 생성 메서드
        // 줄당 로프 갯수와 총 사다리 높이를 입력하면 랜덤으로 사다리를 생성 합니다.
        List<LadderLine> ladderLines = IntStream.rangeClosed(0, request.lineHeight())
                .mapToObj(i -> newRandomLadderLine(request.ropeSize()))
                .collect(Collectors.toList());

        return new Ladder(ladderLines, request.prizes());
    }

    public static Ladder of(List<LadderLine> ladderLines, List<Prize> prizes) {
        return new Ladder(ladderLines, prizes);
    }

    private static LadderLine newRandomLadderLine(int ropeSize) {
        List<Rope> ropes = Stream.iterate(Rope.empty(), Rope::next)
                .limit(ropeSize)
                .collect(Collectors.toList());

        return new LadderLine(ropes);
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
