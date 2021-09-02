package ladderrefactoring;

import ladderrefactoring.domain.WinningResult;
import ladderrefactoring.domain.datas.People;
import ladderrefactoring.domain.datas.Results;
import ladderrefactoring.domain.ladder.Ladder;
import ladderrefactoring.exception.CustomException;
import ladderrefactoring.strategy.LineStrategy;
import ladderrefactoring.strategy.RandomLineStrategy;
import ladderrefactoring.view.InputView;
import ladderrefactoring.view.ResultView;

import java.util.List;

public class LadderGameMain {

    public static void main(String[] args){
        try {
            List<String> peopleString = InputView.inputPeople();
            People people = new People(peopleString);

            List<String> resultsString = InputView.inputResults();
            Results results = new Results(resultsString, people);

            int widthOfLadder = people.subtractNumberFromSize(1);
            int heightOfLadder = InputView.inputHeightOfLadder();
            LineStrategy lineStrategy = new RandomLineStrategy();
            Ladder ladder = new Ladder(widthOfLadder, heightOfLadder, lineStrategy);

            ResultView.showResult(people, ladder, results);

            WinningResult winningResult = new WinningResult(ladder, people, results);
            ResultView.showWinningResult(winningResult);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
