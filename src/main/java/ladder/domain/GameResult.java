package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    private final Map<Name, Prize> result;

    private GameResult(Map<Name, Prize> result) {
        this.result = result;
    }

    public static GameResult of(Ladder ladder, Participants participants, GamePrize gamePrize) {
        List<Prize> prizeList = IntStream.range(0, participants.countOfPerson())
                .mapToObj(index -> gamePrize.prizeOf(indexOfPrize(ladder, index)))
                .collect(Collectors.toList());

        Map<Name, Prize> result = IntStream.range(0, participants.countOfPerson())
                .boxed()
                .collect(Collectors.toMap(participants::nameOf, prizeList::get));

        return new GameResult(result);
    }

    private static int indexOfPrize(Ladder ladder, int indexOfParticipant) {
        Position currentPosition = Position.departurePosition(indexOfParticipant);
        Position result = ladder.arrival(currentPosition);

        return result.getWidth();
    }

    public Map<Name, Prize> getResult() {
        return result;
    }
}
