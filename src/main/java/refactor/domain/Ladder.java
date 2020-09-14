package refactor.domain;

import refactor.domain.pointGenerate.PointStrategy;
import refactor.domain.pointGenerate.RandomPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder init(int ladderHeight, int sizeOfPerson) {
        PointStrategy pointStrategy = new RandomPoint();
        List<LadderLine> ladderLines = new ArrayList<>();
        IntStream.rangeClosed(0, ladderHeight)
                .forEach(i -> ladderLines.add(LadderLine.init(sizeOfPerson,pointStrategy)));
        return Ladder.of(ladderLines);
    }

    public static Ladder of(List<LadderLine> ladderLines) {
        return new Ladder(ladderLines);
    }


    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }
}
