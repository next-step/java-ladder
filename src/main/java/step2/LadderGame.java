package step2;

import step2.ganerator.LadderGenerator;
import step2.model.Ladder;
import step2.model.LadderPrize;
import step2.model.Person;
import step2.uiView.InputView;
import step2.uiView.ResultView;

public class LadderGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String personStr = inputView.inputPerson();
        String lottoPrizeStr = inputView.inputLadderPrize();
        int maxLadder = inputView.inputMaxLadder();

        Person person = Person.createPerson(personStr);

        LadderPrize ladderPrize = LadderPrize.createLadderPrize(person, lottoPrizeStr);
        Ladder ladder = Ladder.createLadder(person, maxLadder, new LadderGenerator());

        ResultView resultView = new ResultView();
        resultView.resultLadderGame(person, ladder, ladderPrize);

        String personName = inputView.inputChoosePerson();
        int[] personIndex = person.getPersonIndex(personName);
        int[] endGameIndex = ladder.startLadderGame(personIndex);

        resultView.resultLadderPrize(ladderPrize, person, endGameIndex);
    }
}
