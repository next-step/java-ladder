package laddergameplay;

import laddergameplay.domain.datas.People;
import laddergameplay.domain.datas.Results;
import laddergameplay.domain.dto.WinningResult;
import laddergameplay.domain.ladder.Ladder;
import laddergameplay.domain.ladder.LadderGame;
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
            People people = new People(peopleString);

            List<String> resultsString = InputView.inputResults();
            Results results = new Results(resultsString, people);

            int heightOfLadder = InputView.inputHeightOfLadder();
            LineStrategy lineStrategy = new RandomLineStrategy();
            Ladder ladder = new Ladder(people, heightOfLadder, lineStrategy);
            LadderGame ladderGame = new LadderGame(ladder);

            ResultView.showResult(people, ladder, results);
            WinningResult winningResult = ladderGame.makeWinningResult(people, results);

            ResultView.showWinningResult(winningResult);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
