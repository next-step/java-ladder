package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;

import java.util.List;
import java.util.Map;

public interface OutputViewInterface {
    void printLadder(List<Name> names, List<LadderLine> ladder, List<Name> results);

    void printResult(Map<Name, Name> result);
}
