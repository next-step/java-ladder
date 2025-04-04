package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLine;

import java.util.List;

public interface OutputViewInterface {
    void printPrompt(String prompt);

    void printNames(String[] names);

    void printLadder(List<LadderLine> ladder);
}
