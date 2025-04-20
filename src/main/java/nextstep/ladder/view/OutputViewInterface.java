package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.Map;

public interface OutputViewInterface {
    void printPrompt(String prompt);

    void printLadder(Participants names, Ladder ladder, Rewards rewards);

    void printAllMatchResult(Map<Name, Name> matched);

    void printResult(Name reward);
}
