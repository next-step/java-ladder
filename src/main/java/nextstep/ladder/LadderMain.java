package nextstep.ladder;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.ArrayList;
import java.util.List;


public class LadderMain {
    public static void main(String[] args) {
        String inputNameOfPerson = InputView.inputNameOfPerson();
        int height = InputView.inputLadderHeight();
        Players players = new Players(inputNameOfPerson);

        ResultView.viewPerson(players);
        ResultView.viewLadder(new Ladder(players, height), players.getCount());
    }
}
