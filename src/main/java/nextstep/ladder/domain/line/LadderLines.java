package nextstep.ladder.domain.line;

import nextstep.ladder.generator.LadderPointGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLines {
    private final List<LadderLine> ladderLines;

    public LadderLines(int playerCount, int ladderHeight, LadderPointGenerator ladderPointGenerator) {
        ladderLines = Stream.generate(() -> LadderLine.init(playerCount, ladderPointGenerator))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    public int findLastPlayerPosition(int playerPosition) {
        int position = playerPosition;

        for (LadderLine ladderLine : ladderLines) {
            position = ladderLine.move(position);
        }

        return position;
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }
}
