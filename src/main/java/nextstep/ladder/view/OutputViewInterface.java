package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Participant;

import java.util.List;

public interface OutputViewInterface {
    void printPrompt(String prompt);

    void printNames(List<Participant> names);

    void printLadder(List<LadderLine> ladder);
}
