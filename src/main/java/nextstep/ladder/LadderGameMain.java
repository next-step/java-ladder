package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Peoples;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameMain {

    public static void main(String[] args) {
        String peopleString = InputView.inputPeoples();
        Peoples peoples = Peoples.parse(peopleString);
        int height = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(peoples.size(), height);

        OutputView.printLadder(ladderGame, peoples);
    }
}
