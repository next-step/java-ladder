package laddergame;

import laddergame.domain.LadderGame;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class LadderGameMain {

    public static void main(String[] args){
        String peopleString = InputView.inputPeople();

        int heightOfLadder = InputView.inputHeightOfLadder();

        LadderGame ladderGame = new LadderGame(peopleString, heightOfLadder);

        ResultView.showResult(ladderGame);
    }
}
