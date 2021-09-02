package ladderrefactoring;

import ladderrefactoring.domain.WinningResult;
import ladderrefactoring.domain.datas.People;
import ladderrefactoring.domain.datas.Results;
import ladderrefactoring.domain.ladder.Ladder;
import ladderrefactoring.exception.CustomException;
import ladderrefactoring.strategy.DirectionStrategy;
import ladderrefactoring.strategy.RandomDirectionStrategy;
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

            int widthOfLadder = people.people().size();
            int heightOfLadder = InputView.inputHeightOfLadder();
            DirectionStrategy directionStrategy = new RandomDirectionStrategy();
            Ladder ladder = new Ladder(widthOfLadder, heightOfLadder, directionStrategy);

            ResultView.showResult(people, ladder, results);

            WinningResult winningResult = new WinningResult(ladder, people, results);
            ResultView.showWinningResult(winningResult);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
