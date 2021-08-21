package laddergame;

import laddergame.domain.LadderGame;
import laddergame.exception.CustomException;
import laddergame.view.InputView;
import laddergame.view.ResultView;

import java.util.List;

public class LadderGameMain {

    public static void main(String[] args){
        try {
            List<String> peopleString = InputView.inputPeople();

            int heightOfLadder = InputView.inputHeightOfLadder();

            LadderGame ladderGame = new LadderGame(peopleString, heightOfLadder);

            ResultView.showResult(ladderGame);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
