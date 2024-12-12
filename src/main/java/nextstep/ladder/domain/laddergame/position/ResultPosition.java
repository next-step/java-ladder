package nextstep.ladder.domain.laddergame.position;

import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.laddergame.LadderGameResult;
import nextstep.ladder.domain.player.Players;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultPosition {
    private final Map<Integer, Integer> positionMap;

    public ResultPosition() {
        this(new HashMap<>());
    }

    public ResultPosition(Map<Integer, Integer> positionMap) {
        this.positionMap = positionMap;
    }

    public void add(int start, int finish) {
        positionMap.put(start, finish);
    }

    public int getFinishPosition(int startPosition) {
        return positionMap.get(startPosition);
    }

    public LadderGameResult match(Players players, LadderResult ladderResult) {
        LadderGameResult ladderGameResult = new LadderGameResult();

        IntStream.range(0, players.getPlayers().size())
                 .forEach(i -> {
                     String name = players.getPlayers().get(i).getName();
                     String result = ladderResult.getResultByIndex(getFinishPosition(i));
                     ladderGameResult.add(name, result);
                 });

        return ladderGameResult;
    }

}
