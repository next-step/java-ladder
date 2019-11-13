package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Peoples;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameMain {

    public static void main(String[] args) {
        String names = InputView.inputPeoples();
        Peoples peoples = Peoples.of(names);
        int height = InputView.inputLadderHeight();

        Ladder ladder = LadderGame.newInstance(peoples.size(), height);

        OutputView.printLadder(ladder, peoples);
    }
}
