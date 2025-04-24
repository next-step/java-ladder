package nextstep.ladder;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.ArrayList;
import java.util.List;


public class LadderMain {
    public static void main(String[] args) {
        String inputNameOfPerson = InputView.inputNameOfPerson();
        String result  = InputView.inputLadderResult();

        int height = InputView.inputLadderHeight();
        Players players = new Players(inputNameOfPerson);
        ResultView.viewPerson(players);

        Ladder ladder = new Ladder(players, height, result);
        ResultView.viewLadder(ladder, players.getCount());
        ResultView.viewGameResult(ladder.play(players), InputView.inputPlayerOrAll());
    }
}
