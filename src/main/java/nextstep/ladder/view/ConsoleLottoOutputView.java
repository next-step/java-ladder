package nextstep.ladder.view;


import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.WinningItems;

import static nextstep.ladder.view.OutputView.print;

public class ConsoleLottoOutputView implements LadderOutputView {

    @Override
    public void ladderOutput(Players players, Ladder ladder, WinningItems winningItems) {
        print("사다리 결과\n" + players.toString() + "\n" + ladder.toString() + "\n" + winningItems.toString());
    }

    @Override
    public void ladderGameOutPut(LadderGameResult ladderGameResult) {
        print("실행 결과\n" + ladderGameResult.toString());
    }
}
