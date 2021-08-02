package ladder.domain;

import ladder.exception.InvalidRopeException;

import java.util.Iterator;
import java.util.List;
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

    public static Ladder generate(int ropeSize, int lineHeight) {
        List<LadderLine> ladderLines = IntStream.rangeClosed(0, lineHeight)
                .mapToObj(i -> randomLadderLine(ropeSize))
                .collect(Collectors.toList());

        return new Ladder(ladderLines);
    }

    private static LadderLine randomLadderLine(int ropeSize) {
        int ropePosition = random.nextInt(2);
        List<Rope> ropes = IntStream.range(0, ropeSize - 1)
                .mapToObj(iRopeCount ->
                        iRopeCount % 2 == ropePosition ? newRope() : Rope.empty())
                .collect(Collectors.toList());

        return new LadderLine(ropes);
    }

    private static Rope newRope() {
        return Rope.of(random.nextBoolean());
    }

    @Override
    public Iterator<LadderLine> iterator() {
        return this.ladderLines.iterator();
    }
}
