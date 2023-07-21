package nextstep.ladder.view;


import nextstep.ladder.domain.Ladder;

import static nextstep.ladder.view.OutputView.print;

public class ConsoleLottoOutputView implements LadderOutputView {

    @Override
    public void ladderOutput(Ladder ladder) {
        print("실행결과");
        print(ladder.toString());
    }
}
