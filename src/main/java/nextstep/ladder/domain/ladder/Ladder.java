package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.size.LadderSize;
import nextstep.ladder.domain.ladder.size.LadderWidth;
import nextstep.ladder.domain.rule.WayRule;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.utils.Validation.checkNotEmpty;
import static nextstep.ladder.utils.Validation.checkNotNull;

public class Ladder {

    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        checkNotEmpty(ladderLines);
        this.ladderLines = ladderLines;
    }

    public static Ladder of(LadderSize ladderSize, WayRule wayRule) {
        checkNotNull(ladderSize, wayRule);

        int height = ladderSize.height();
        LadderWidth ladderWidth = ladderSize.getLadderWidth();
        return new Ladder(createLadderLines(height, ladderWidth, wayRule));
    }

    private static List<LadderLine> createLadderLines(int height, LadderWidth ladderWidth, WayRule wayRule) {
        return Stream.generate(() -> LadderLine.of(ladderWidth, wayRule))
                .limit(height)
                .collect(Collectors.toList());
    }
}
