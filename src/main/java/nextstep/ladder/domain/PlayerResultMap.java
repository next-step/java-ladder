package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;

import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Line;
import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prize;
import nextstep.ladder.engine.Prizes;
import nextstep.ladder.engine.ResultMap;

public class PlayerResultMap implements ResultMap {
    final Prizes original;
    final Map<Prize, Index> resultIndexMap;

    private PlayerResultMap(Prizes original, Map<Prize, Index> resultIndexMap) {
        this.original = original;
        this.resultIndexMap = resultIndexMap;
    }

    public static PlayerResultMap of(Prizes original) {
        return new PlayerResultMap(original, LadderResultMapComposer.of(original).compose());
    }

    public void move(List<Line> lines) {
        lines.forEach(this::moveLine);
    }

    private void moveLine(Line line) {
        original.forEach(prize -> resultIndexMap.compute(prize, ((prizeAsKey, index) -> line.move(index))));
    }

    public GameResult result(Players players) {
        Map<Name, Prize> resultMap = LadderGameResultComposer.of(players, resultIndexMap).compose();
        return LadderGameResult.of(resultMap);
    }
}
