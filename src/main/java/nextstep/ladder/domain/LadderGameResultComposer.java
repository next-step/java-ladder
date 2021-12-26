package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

import nextstep.ladder.engine.GameResultComposer;
import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prize;

public class LadderGameResultComposer implements GameResultComposer {
    private final Players players;
    private final Map<Prize, Index> resultIndexMap;
    private final Map<Name, Prize> resultMap = new HashMap<>();


    public LadderGameResultComposer(Players players, Map<Prize, Index> resultIndexMap) {
        this.players = players;
        this.resultIndexMap = resultIndexMap;
    }

    public static GameResultComposer of(Players players, Map<Prize, Index> resultIndexMap) {
        if (players == null || resultIndexMap == null) {
            throw new IllegalArgumentException("players or result map cannot be null");
        }

        if (players.size() != resultIndexMap.size()) {
            throw new IllegalArgumentException("players and result map must have same size.");
        }

        return new LadderGameResultComposer(players, resultIndexMap);
    }

    @Override
    public Map<Name, Prize> compose() {
        resultIndexMap.forEach(this::zip);
        return resultMap;
    }

    private void zip(Prize prize, Index index) {
        resultMap.put(players.elementOf(index.toInt()), prize);
    }
}
