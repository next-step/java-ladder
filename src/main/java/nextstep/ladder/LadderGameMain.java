package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Ladders;
import nextstep.ladder.domain.Peoples;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameMain {

    public static void main(String[] args) {
        String names = InputView.inputPeoples();
        Peoples peoples = Peoples.of(names);
        int height = InputView.inputLadderHeight();

        Ladders ladders = LadderGame.newInstance(peoples.size(), height);

        OutputView.printLadder(ladders, peoples);
    }
}
