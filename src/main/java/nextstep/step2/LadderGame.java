package nextstep.step2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

    private static final int START_Y_POSITION = 0;

    private Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public GameResult gameStart(Entries entries, Results results) {
        validateEntriesAndResults(entries, results);
        Map<String, String> resultMap = entries.getParticipantList().stream()
                .collect(Collectors.toMap(
                        Participant::getName,
                        participant -> {
                            int startXPosition = entries.getParticipantList().indexOf(participant);
                            Position position = new Position(startXPosition, START_Y_POSITION);
                            int resultIndex = ladder.move(position);
                            return results.getResults().get(resultIndex);
                        },
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        return new GameResult(resultMap);
    }

    private void validateEntriesAndResults(Entries entries, Results results) {
        if (entries.getParticipantListSize() != results.getResultsSize()) {
            throw new IllegalArgumentException("The number of entries and results must be the same.");
        }
    }
}
