package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<LadderLine> ladderLines;

    public Ladder(int ladderHeight, int userCount) {
        ladderLines = Stream.generate(() -> LadderLine.init(userCount)).limit(ladderHeight).collect(Collectors.toList());
    }

    public int move(int position) {
        int result = position;
        for (LadderLine ladderLine : ladderLines) {
            result = ladderLine.move(result);
        }
        return result;
    }

    public List<LadderLine> getLadder() {
        return ladderLines;
    }


}
