package step3_renewal.domain;

import step3_renewal.exception.MinHeightException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final Integer MIN_HEIGHT = 1;

    private List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder of(int maxHeight, Participants participants) {
        validate(maxHeight);
        List<LadderLine> ladderLines =
                IntStream.range(0, maxHeight)
                        .mapToObj(i -> LadderLine.init(participants.getParticipants().size()))
                        .collect(Collectors.toList());
        return new Ladder(ladderLines);
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public int move(int beginPosition) {
        int currentPosition = beginPosition;
        for (LadderLine line : Collections.unmodifiableList(ladderLines)) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }

    private static void validate(int maxHeight) {
        if(maxHeight < MIN_HEIGHT) {
            throw new MinHeightException(MIN_HEIGHT);
        }
    }
}
