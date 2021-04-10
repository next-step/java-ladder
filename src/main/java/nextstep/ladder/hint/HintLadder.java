package nextstep.ladder.hint;

import nextstep.ladder.domain.Height;
import nextstep.ladder.service.Participants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class HintLadder {
    private final List<HintLadderLine> ladderLine;

    private HintLadder(final HintLadderLine... ladderLine) {
        this.ladderLine = Arrays.asList(ladderLine);
    }

    public static HintLadder valueOf(final Participants participants, final Height height) {

        HintLadderLine[] hintLadderLines = Stream.generate(() -> HintLadderLine.init(participants.size()))
                .limit(height.size())
                .toArray(HintLadderLine[]::new);

        return new HintLadder(hintLadderLines);
    }

    public int findEndPosition(int movePosition) {
        for (HintLadderLine hintLadderLine : ladderLine) {
            movePosition = hintLadderLine.move(movePosition);
        }
        return movePosition;
    }

    public List<HintLadderLine> lines() {
        return Collections.unmodifiableList(ladderLine);
    }

    @Override
    public String toString() {
        return String.valueOf(ladderLine);
    }
}
