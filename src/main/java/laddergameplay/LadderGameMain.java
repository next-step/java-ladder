package laddergameplay;

import laddergameplay.domain.Ladder;
import laddergameplay.domain.People;
import laddergameplay.exception.CustomException;
import laddergameplay.strategy.LineStrategy;
import laddergameplay.strategy.RandomLineStrategy;
import laddergameplay.view.InputView;
import laddergameplay.view.ResultView;

import java.util.List;

public class LadderGameMain {

    public static void main(String[] args){
        try {
            List<String> peopleString = InputView.inputPeople();

            int heightOfLadder = InputView.inputHeightOfLadder();

            People people = new People(peopleString);

            int countOfPeople = peopleString.size();
            LineStrategy lineStrategy = new RandomLineStrategy();
            Ladder ladder = new Ladder(countOfPeople, heightOfLadder, lineStrategy);

            ResultView.showResult(people, ladder);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
