package step4.laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder of(Size size, LadderPointerGenerator generator) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < size.getHeight(); i++) {
            ladderLines.add(
                    LadderLine.init(size.getWidth(), generator)
            );
        }
        return new Ladder(ladderLines);
    }

    private int move(int index) {
        int now = index;
        for(LadderLine ladderLine : ladderLines) {
            now = ladderLine.move(now);
        }
        return now;
    }

    public List<Integer> moveAll() {
        return IntStream.rangeClosed(0, ladderLines.size())
                .mapToObj(this::move)
                .collect(toCollection(ArrayList::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
