package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLine> lines;

    public Ladder(int width, int height) {
        this(
                Stream.generate(
                        () -> LadderLine.from(width))
                        .limit(height)
                        .collect(Collectors.toList())
        );
    }

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public List<LadderLine> ladderLines() {
        return Collections.unmodifiableList(lines);
    }

    public LadderResults ladderResults(Names names, Prizes prizes) {
        final List<LadderResult> ladderResults = new ArrayList<>();

        for (int i = 0; i < names.count(); i++) {
            final Name name = names.get(i);
            final Prize prize = prizes.get(prizeIndex(i));

            ladderResults.add(new LadderResult(name, prize));
        }

        return new LadderResults(ladderResults);
    }

    private int prizeIndex(int nameIndex) {
        for (final LadderLine line : lines) {
            nameIndex = line.nextIndex(nameIndex);
        }

        return nameIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
