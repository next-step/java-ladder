package nextstep.ladder.view.output.list;

import nextstep.ladder.domain.MatchResult;
import nextstep.ladder.view.output.ListView;

import java.util.Collection;

public class LadderResulView extends ListView {

    @Override
    protected Collection<String> getList(MatchResult matchResult) {
        return matchResult.ladderResults();
    }
}
