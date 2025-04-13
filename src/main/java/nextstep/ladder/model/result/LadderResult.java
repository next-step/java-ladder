package nextstep.ladder.model.result;

import nextstep.ladder.model.ladder.Ladder;
import nextstep.ladder.model.player.Player;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.model.ladder.Position;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResult {
    private final Map<Player, Result> results;
    
    public LadderResult(final Players players, final List<Result> resultValues, final Ladder ladder) {
        this.results = IntStream.range(0, players.count())
                .boxed()
                .collect(Collectors.toMap(players::get, i -> resultValues.get(ladder.run(new Position(i)).getValue())));
    }
    
    public Result getResult(final Player player) {
        return results.get(player);
    }
    
    public Map<Player, Result> getAllResults() {
        return results;
    }
}
