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
        Map<String, String> resultMap = entries.getHumanList().stream()
                .collect(Collectors.toMap(
                        Participant::getName,
                        participant -> {
                            int startXPosition = entries.getHumanList().indexOf(participant);
                            Position position = new Position(startXPosition, START_Y_POSITION);
                            int resultIndex = ladder.move(position);
                            return results.getResults().get(resultIndex);
                        },
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        return new GameResult(resultMap);
    }
}
