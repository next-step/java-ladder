package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

import nextstep.ladder.engine.Prize;
import nextstep.ladder.engine.Prizes;
import nextstep.ladder.engine.ResultMapComposer;

public class LadderResultMapComposer implements ResultMapComposer {
    private final Prizes prizes;
    private final Map<Prize, Index> resultIndexMap;

    public LadderResultMapComposer(Prizes prizes) {
        this.prizes = prizes;
        this.resultIndexMap = new HashMap<>();
    }

    public static ResultMapComposer of(Prizes prizes) {
        if (prizes == null) {
            throw new IllegalArgumentException("prizes cannot be null");
        }

        return new LadderResultMapComposer(prizes);
    }

    @Override
    public Map<Prize, Index> compose() {
        prizes.forEach(this::putPrize);
        return resultIndexMap;
    }

    private void putPrize(Prize prize) {
        resultIndexMap.put(prize, Index.of(prizes.indexOf(prize)));
    }
}
