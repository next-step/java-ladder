package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLineOld> lines;

    private Ladder(final List<LadderLineOld> lines) {
        validate(lines);
        this.lines = Collections.unmodifiableList(lines);
    }

    private void validate(final List<LadderLineOld> lines) {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            throw new IllegalArgumentException("Ladder Lines must be existed.");
        }
    }

    public static Ladder newInstance(final PoleCount poleCount, final LadderHeight height) {
        return newInstance(poleCount.toInt(), height.toInt());
    }

    public static Ladder newInstance(final int poleCount, final int height) {
        List<LadderLineOld> ladders = IntStream.range(0, height)
                .mapToObj(i -> LadderLineOld.newInstance(poleCount))
                .collect(Collectors.toList());
        return new Ladder(ladders);
    }

    public static Ladder newInstance(final List<LadderLineOld> ladderLines) {
        return new Ladder(ladderLines);
    }

    public LadderPoles proceedAll() {
        List<LadderPole> ladderPoles = IntStream.range(0, getPoleCount())
                .mapToObj(i -> proceed(LadderPole.of(i)))
                .collect(Collectors.toList());

        return LadderPoles.newInstance(ladderPoles);
    }

    public LadderPole proceed(final LadderPole ladderPole) {
        LadderPole preLadderPole = LadderPole.of(ladderPole);

        for (LadderLineOld line : lines) {
            preLadderPole = line.moveLadderPole(preLadderPole);
        }

        return preLadderPole;
    }

    public int getPoleCount() {
        return lines.stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("ladderLine must be existed."))
                .poleCount();
    }

    public List<LadderLineOld> getLines() {
        return lines;
    }
}
