package nextstep.ladder;

import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.generator.LadderGenerator;
import nextstep.ladder.domain.name.Names;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String[] args) {
        Names names = new Names(InputView.getNames());
        Height height = new Height(InputView.getHeight());

        Ladder ladder = LadderGenerator.generateLadder(names.count(), height);

        ResultView.result(names, ladder);
    }
}
