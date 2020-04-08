package JavaLadder;

import JavaLadder.domain.*;
import JavaLadder.view.InputView;
import JavaLadder.view.OutputView;

public class JavaLadder {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputName = inputView.askName();
        String prize = inputView.askPrize();
        GameInformation gameInformation = new GameInformation(inputName, prize);
        int ladderHeight = inputView.askLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, gameInformation);
        OutputView outputView = new OutputView();
        outputView.showLadder(gameInformation, ladder);
        System.out.println(gameInformation.getUser());
        ladder.moveForResult(gameInformation);
        String resultBuyPerson = inputView.askResultByPerson();
        Results results = new Results(gameInformation, resultBuyPerson);
        outputView.showResult(results, gameInformation);
    }
}