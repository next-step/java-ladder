package Ladder;

import view.InputView;
import view.ResultView;

import static view.ResultView.showResult;

public class LadderMain {

    public static void main(String[] args) throws Exception {
        final boolean NOT_ALL = true;

        Persons persons = new Persons(InputView.inputPersonNames());
        Results results = new Results(InputView.inputTotalResults());

        int height = InputView.inputLadderCount();
        Lines lines = new Lines(persons, height);

        ResultView.ladderResultView(lines, results);

        LadderGame ladderGame = new LadderGame(lines);

        LadderResult ladderResult = ladderGame.calculateResult(persons, results);

        while (NOT_ALL) {
            String name = InputView.inputResultPersonName();
            showResult();
            if (name.equals("all")) {
                System.out.println(ladderResult.toString());
                break;
            }
            System.out.println(ladderResult.oneResult(name));

        }
    }


}

