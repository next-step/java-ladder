package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private LineBuildStrategy lineBuildStrategy;

    public LadderGame(LineBuildStrategy lineBuildStrategy) {
        this.lineBuildStrategy = lineBuildStrategy;
    }

    public LadderGameResult start(String[] playerNames, int ladderMaxHeight){
        Players players = new Players(playerNames);
        return new LadderGameResult(build(players, ladderMaxHeight), players);
    }

    private Ladders build(Players players, int ladderMaxHeight) {

        Ladders ladders = new Ladders(IntStream.range(0, ladderMaxHeight)
                .mapToObj(ladder -> new Ladder(lineBuildStrategy.build(players.getPlayers().size())))
                .collect(Collectors.toList()));


        return ladders;
    }
}
