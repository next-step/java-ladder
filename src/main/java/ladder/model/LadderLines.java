package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLines {

    private final List<LadderLine> lines;

    private LadderLines(final List<LadderLine> lines) {
        validate(lines);
        this.lines = Collections.unmodifiableList(lines);
    }

    private void validate(final List<LadderLine> lines) {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            throw new IllegalArgumentException("Ladder Lines must be existed.");
        }
    }

    public static LadderLines newInstance(final int poleCount, final int height) {
        return newInstance(poleCount, LadderHeight.newInstance(height));
    }

    public static LadderLines newInstance(final int poleCount, final LadderHeight height) {
        List<LadderLine> ladders = IntStream.range(0, height.toInt())
                .mapToObj(i -> LadderLine.newInstance(poleCount))
                .collect(Collectors.toList());
        return new LadderLines(ladders);
    }

    public static LadderLines newInstance(final List<LadderLine> ladderLines) {
        return new LadderLines(ladderLines);
    }

    public List<LadderLine> getLines() {
        return lines;
    }

    public int getPoleCount() {
        return lines.stream()
                .findAny()
                .map(LadderLine::getPoleCount)
                .orElseThrow(() -> new IllegalArgumentException("Can not find ladder line pole count."));
    }

    public List<LadderPole> proceedAll() {
        return IntStream.range(0, getPoleCount())
                .mapToObj(this::proceed)
                .collect(Collectors.toList());
    }

    public LadderPole proceed(int polePosition) {
        LadderPole prePosition = LadderPole.of(polePosition);

        for (LadderLine ladderLine : lines) {
            prePosition = ladderLine.proceed(prePosition);
        }
        return prePosition;
    }
}
