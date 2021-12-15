package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder init(int sizeOfPerson, int height) {
        List<LadderLine> ladderLines = IntStream.range(0, height)
                .boxed()
                .map(x -> LadderLine.init(sizeOfPerson))
                .collect(Collectors.toList());
        return new Ladder(ladderLines);
    }

    public int move(int index){
        for(LadderLine ladderLine: ladderLines){
            index = ladderLine.move(index);
        }
        return index;
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }
}
