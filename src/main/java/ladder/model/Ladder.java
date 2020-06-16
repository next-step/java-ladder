package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

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

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
