package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(GameAttendees gameAttendees, int ladderHeight, HorizontalLineStrategy strategy) {
        this.ladderLines = createLadderLinesBy(gameAttendees, ladderHeight, strategy);
    }

    private List<LadderLine> createLadderLinesBy(final GameAttendees gameAttendees, final int ladderHeight, final HorizontalLineStrategy strategy) {
        final List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladderLines.add(new LadderLine(gameAttendees.getNumberOfGameAttendees(), strategy));
        }
        return ladderLines;
    }

    public LadderResult playLadderGame(final GameAttendees gameAttendees, final LadderCompensation ladderCompensation) {
        if (gameAttendees.getNumberOfGameAttendees() != ladderCompensation.getNumberOfCompensation()) {
            throw new IllegalArgumentException();
        }
        final Map<String, String> gameResult = new HashMap<>();
        for (int startPos = 0; startPos < gameAttendees.getNumberOfGameAttendees(); startPos++) {
            gameResult.put(gameAttendees.getGameAttendees(startPos), ladderCompensation.getCompensation(getAttendeesFinalPosition(startPos)));
        }
        return new LadderResult(gameResult);
    }

    private int getAttendeesFinalPosition(final int attendeesStartPosition) {
        int currentPosition = attendeesStartPosition;
        for (LadderLine ladderLine : ladderLines) {
            currentPosition = ladderLine.moveLine(currentPosition);
        }
        return currentPosition;
    }

    @Override
    public String toString() {
        return ladderLines.stream()
                .map((LadderLine::toString))
                .collect(Collectors.joining("\n"));
    }

}
