package ladder.model;

import ladder.utils.Validation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        Validation.validateEmpty(lines);
        this.lines = lines;
    }

    public static Ladder create(int memberCount, int ladderHeight) {
        List<LadderLine> lines = Stream.generate(() -> LadderLine.create(memberCount))
                .limit(ladderHeight)
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public static Ladder create(final List<LadderLine> ladderLines) {
        return new Ladder(ladderLines);
    }

    public LadderPoles proceedAll() {
        List<LadderPole> ladderPoles = IntStream.range(0, getPoleCount())
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
