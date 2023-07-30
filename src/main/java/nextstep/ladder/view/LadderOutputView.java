package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.WinningItems;

public interface LadderOutputView {

    void ladderOutput(Players players, Ladder ladder, WinningItems winningItems);

    void ladderGameOutPut(LadderGameResult ladderGameResult);
}
