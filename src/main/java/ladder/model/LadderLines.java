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

    public static LadderLines newInstance(final int count, final int height) {
        return newInstance(MemberCount.of(count), LadderHeight.newInstance(height));
    }

    public static LadderLines newInstance(final MemberCount memberCount, final LadderHeight height) {
        List<LadderLine> ladders = IntStream.range(0, height.toInt())
                .mapToObj(i -> LadderLine.newInstance(memberCount))
                .collect(Collectors.toList());
        return new LadderLines(ladders);
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
}
