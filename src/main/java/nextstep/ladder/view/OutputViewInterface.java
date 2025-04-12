package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Results;

import java.util.List;

public interface OutputViewInterface {
    void printLadder(List<Name> names, List<LadderLine> ladder, List<Name> results);

    void printGameResult(List<Name> names, Results matchResults);
}
