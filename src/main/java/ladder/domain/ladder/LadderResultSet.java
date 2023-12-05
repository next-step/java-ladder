package ladder.domain.ladder;

import ladder.domain.Name;
import ladder.domain.ResultItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 사다리 게임 결과를 담고 있는 데이터 객체입니다.
 * 가변 객체입니다.
 */
public class LadderResultSet {

    private final List<LadderResult> resultSet;

    public LadderResultSet() {
        this.resultSet = new ArrayList<>();
    }

    public void addResultMapping(Name name, ResultItem resultItem) {
        this.addResultMapping(new LadderResult(name, resultItem));
    }

    public void addResultMapping(LadderResult ladderResult) {
        this.resultSet.add(ladderResult);
    }

    public Iterable<LadderResult> toIterable() {
        return this.resultSet;
    }
}