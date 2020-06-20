package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private static final int ZERO = 0;
    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(final List<LadderLine> lines) {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 라인은 하나 이상이어야 합니다.");
        }
    }

    public static Ladder create(int memberCount, int ladderHeight) {
        List<LadderLine> lines = Stream.generate(() -> LadderLine.create(memberCount))
            .limit(ladderHeight)
            .collect(Collectors.toList());

        return new Ladder(lines);
    }


    public LadderPoles proceedAll() {
        List<LadderPole> ladderPoles = IntStream.range(ZERO, getPoleCount())
            .mapToObj(i -> proceed(LadderPole.create(i)))
            .collect(Collectors.toList());

        return LadderPoles.create(ladderPoles);
    }

    private int getPoleCount() {
        return lines.stream()
            .findAny()
            .orElseThrow(() -> new RuntimeException("사다리 라인이 존재하지 않습니다."))
            .poleCount();
    }

    public LadderPole proceed(final LadderPole ladderPole) {
        LadderPole preLadderPole = LadderPole.create(ladderPole);

        for (LadderLine line : lines) {
            preLadderPole = line.moveLadderPole(preLadderPole);
        }

        return preLadderPole;
    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
