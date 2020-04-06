package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private Ladder ladder;
    private Participants participants;

    public LadderGame(List<String> names,
                      int height,
                      RightDirection rightDirection,
                      LineSelector lineSelector) {
        participants = new Participants(names);
        LadderSize ladderSize = new LadderSize(participants.size(), height);
        ladder = Ladder.of(createHorizontalLine(ladderSize), lineSelector,
                rightDirection);
    }

    private List<HorizontalLine> createHorizontalLine(LadderSize ladderSize) {
        return IntStream.range(0, ladderSize.getHeight())
                .mapToObj(index -> HorizontalLine.of(ladderSize.getWidth()))
                .collect(Collectors.toList());
    }

    public int getLadderSize() {
        return ladder.size();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Participants getParticipants() {
        return participants;
    }
}
