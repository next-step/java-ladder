package step4.domain;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder of(int ladderDepth, int sizeOfPerson, LadderPointGenerator ladderPointGenerator) {
        return new Ladder(
                IntStream.range(0, ladderDepth)
                        .mapToObj(index -> LadderLine.init(sizeOfPerson, ladderPointGenerator))
                        .collect(Collectors.toList()));
    }

    public Position getLadderEndResult(Position position) {

        for (int i=0; i<ladderLines.size(); i++) {
            int movedPosition = ladderLines.get(i).move(position.getPosition());
            position = position.move(movedPosition);
        }

        return position;
    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(ladderLines);
    }
}
